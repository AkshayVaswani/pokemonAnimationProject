package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;


public class pokemonActor extends Actor {


    Sprite sprite;
    int x = 0;
    int y;
    int lvl;
    TextureAtlas textureAtlas;
    Rectangle rectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
    Animation<TextureRegion> stillAnimation;
    MoveToAction moveToAction = new MoveToAction();
    float timeForStill = 0.0f;
    float timeforMove = 0.0f;

    public pokemonActor() {
        int random = (int) (Math.random() * 5) + 1;
        switch (random) {
            case 1:
                sprite = new Sprite(new Texture(Gdx.files.internal("dratiniPics/tile000.png")));
                textureAtlas = new TextureAtlas(Gdx.files.internal("dratiniSprites/dratiniAtlas.atlas"));
                break;
            case 2:
                sprite = new Sprite(new Texture(Gdx.files.internal("dratiniPics/tile000.png")));
                textureAtlas = new TextureAtlas(Gdx.files.internal("flareonSprites/flareonAtlas.atlas"));
                break;
            case 3:
                sprite = new Sprite(new Texture(Gdx.files.internal("dratiniPics/tile000.png")));
                textureAtlas = new TextureAtlas(Gdx.files.internal("dratiniSprites/dratiniAtlas.atlas"));
                break;
            case 4:
                sprite = new Sprite(new Texture(Gdx.files.internal("flareonPics/tile000.png")));
                textureAtlas = new TextureAtlas(Gdx.files.internal("flareonSprites/flareonAtlas.atlas"));
                break;
            case 5:
                sprite = new Sprite(new Texture(Gdx.files.internal("dratiniPics/tile000.png")));
                textureAtlas = new TextureAtlas(Gdx.files.internal("dratiniSprites/dratiniAtlas.atlas"));
                break;
        }
        stillAnimation = new Animation(1 / 10f, textureAtlas.getRegions());


        lvl = (int) (Math.random() * 3) + 1;
        switch (lvl) {
            case 1:
                y = 125;
                break;
            case 2:
                y = 250;
                break;
            case 3:
                y = 375;
                break;
        }

        setX(x);
        setY(y);
        setBounds(getX(), getY(), sprite.getWidth(), sprite.getHeight());
        //move = !move;
        moveToAction.setPosition(1441f, getY());
        moveToAction.setDuration((float) (Math.random() * 6) + 3);
        addAction(moveToAction);

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public MoveToAction getAction() {
        return moveToAction;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeForStill += Gdx.graphics.getDeltaTime();
        batch.draw(stillAnimation.getKeyFrame(timeForStill, true), getX(), getY());
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
    }
}