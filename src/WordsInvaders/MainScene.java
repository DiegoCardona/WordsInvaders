package WordsInvaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MainScene extends Application {

    private static final Random RAND = new Random();
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 60;
    private static final int ENEMY_SIZE = 80;
    private static final int MAX_ENEMIES = 5;
    private static final int TIME_TO_CREATE_ENEMIES = 1;
    private long lastTime;

    private GraphicsContext gc;
    private double mouseX;
    private Player player;
    private List<Universe> univ;
    private List<Enemy> enemies;
    private Canvas canvas;
    private final WordsDB wordsDB = new WordsDB();
    private Goal goal;
    private boolean won = false;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        goal = new Goal(gc);
        goal.updateTexts(this.wordsDB.words.get(new Random().nextInt(this.wordsDB.words.size())));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        canvas.setCursor(Cursor.MOVE);
        canvas.setOnMouseMoved(e -> mouseX = e.getX());
        canvas.setOnMouseClicked(e -> {
            gc.setFill(Color.BLUE);
            gc.fillOval(this.player.positionX, this.player.positionY, this.player.size, this.player.size);
        });
        setup();
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.setTitle("words Invaders");
        stage.show();
    }

    private void setup() {
        this.player = new Player(WIDTH/2, HEIGHT - PLAYER_SIZE, PLAYER_SIZE, this.canvas);
        univ = new ArrayList<>();
        enemies = new ArrayList<>();
        createEnemies();
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.grayRgb(20));
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font(20));
        gc.setFill(Color.WHITE);
        gc.fillText("Current wave: " + this.player.getCurrentLevel(), 60,  20);

        // Goal word text
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font(20));
        gc.setFill(Color.WHITE);
        gc.fillText("Goal Word: " + this.goal.textSpanish, WIDTH/2,  20);


        if(this.player.getLives() == 0) {
            gc.setFont(Font.font(35));
            gc.setFill(Color.YELLOW);
            gc.fillText("Game Over \n Your progress is wave #" + this.player.getCurrentLevel() + " \n Mistakes attacking enemies: " + this.player.getWrongEnemiesBeaten() + " \n Click to play again", WIDTH / 2, HEIGHT /2.5);
            cleanScreen();
        } else if (won) {
            gc.setFont(Font.font(35));
            gc.setFill(Color.GREENYELLOW);
            gc.fillText("You WON!!! \n Your progress is wave #" + this.player.getCurrentLevel() + " \n Mistakes attacking enemies: " + this.player.getWrongEnemiesBeaten() + " \n Click to play again", WIDTH / 2, HEIGHT /2.5);
            cleanScreen();
        }

        if ((Instant.now().getEpochSecond() - lastTime) > TIME_TO_CREATE_ENEMIES && !won && this.player.getLives() > 0){
            createEnemies();
        }

        univ.forEach(Universe::draw);

        player.update();
        player.draw();
        player.positionX = (int) this.mouseX;

        enemies.stream().peek(Enemy::update).peek(e -> e.draw(ENEMY_SIZE)).forEach(e -> {
            if(player.collide(e)) {
                player.beaten();
            }
        });

        List<Enemy> enemiesToRemove = new ArrayList<>();
        List<Bullet> bulletsToRemove = new ArrayList<>();
        this.player.bulletList.forEach(bullet -> this.enemies.forEach(enemy -> {
            if (bullet.collide(enemy)) {
                enemiesToRemove.add(enemy);
                bulletsToRemove.add(bullet);
                if (bullet.expectedImpact(enemy, this.goal) && bullet.getClass() == BlueBullet.class) {
                    won = true;
                } else if(!bullet.expectedImpact(enemy, this.goal)) {
                    this.player.wrongEnemy();
                }
                enemy.kill();
            }})
        );

        enemiesToRemove.forEach(enemy -> this.enemies.remove(enemy));
        bulletsToRemove.forEach(bullet -> this.player.bulletList.remove(bullet));

        if(RAND.nextInt(10) > 2) {
            univ.add(new Universe());
        }

        for (int i = 0; i < univ.size(); i++) {
            if(univ.get(i).posY > HEIGHT)
                univ.remove(i);
        }
    }

    //environment
    public class Universe {
        int posX, posY;
        private int h, w, r, g, b;
        private double opacity;

        public Universe() {
            posX = RAND.nextInt(WIDTH);
            posY = 0;
            w = RAND.nextInt(5) + 1;
            h =  RAND.nextInt(5) + 1;
            r = RAND.nextInt(100) + 150;
            g = RAND.nextInt(100) + 150;
            b = RAND.nextInt(100) + 150;
            opacity = RAND.nextFloat();
            if(opacity < 0) opacity *=-1;
            if(opacity > 0.5) opacity = 0.5;
        }

        public void draw() {
            if(opacity > 0.8) opacity-=0.01;
            if(opacity < 0.1) opacity+=0.01;
            gc.setFill(Color.rgb(r, g, b, opacity));
            gc.fillOval(posX, posY, w, h);
            posY+=20;
        }
    }

    private void createEnemies() {
        IntStream.range(0, MAX_ENEMIES).mapToObj(i -> {
            Enemy enemy = new Enemy(gc, WIDTH);
            enemy.updateTexts(wordsDB.words.get(new Random().nextInt(wordsDB.words.size())));
            return enemy;
        }).forEach(enemies::add);
        lastTime = Instant.now().getEpochSecond();
    }

    private void cleanScreen() {
        if (!enemies.isEmpty()) {
            enemies.subList(0, enemies.size()).clear();
        }
    }
}
