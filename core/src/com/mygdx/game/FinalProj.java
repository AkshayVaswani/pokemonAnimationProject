package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


import java.beans.Visibility;
import java.util.ArrayList;

public class FinalProj extends ApplicationAdapter {
    Stage stage;
	SpriteBatch batch;
	Texture img;
	TextureAtlas textureAtlas;
    TextureAtlas moveTextureAtlas;
	TextureAtlas backTextureAtlas;
    TextureRegion backTextureRegion;
    Rectangle rectangle;
    ArrayList<pokemonActor> list = new ArrayList<pokemonActor>();
    Sprite backSprite;
	Animation<TextureRegion> stillAnimation;
    Animation<TextureRegion> moveAnimation;
	int backFrame = 1;
	float timeForStill = 0.0f;
    boolean isChosen =false;
    boolean isVisible = true;
    boolean isMade=false;
    boolean caught=false;
    BitmapFont bitmapFont;
    int yVal=250;
    int score =0;


	@Override
	public void create () {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Skin mySkin1 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Skin mySkin3 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Skin mySkin4 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
		batch = new SpriteBatch();

        rectangle=new Rectangle(1200,yVal,200,200);


        ImageButton femaleBtn = new ImageButton(mySkin1);
        femaleBtn.setSize(col_width*4,(float)(row_height*2));
        femaleBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("femaleSpritePics/tile000.png"))));
        femaleBtn.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("femaleSpritePics/tile000.png"))));
        femaleBtn.setPosition(col_width*6,Gdx.graphics.getHeight()-row_height*6);
        femaleBtn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                textureAtlas = new TextureAtlas(Gdx.files.internal("femaleSprites/femaleAtlas.atlas"));
                stillAnimation = new Animation(1 / 10f, textureAtlas.getRegions());
                moveTextureAtlas = new TextureAtlas(Gdx.files.internal("femaleCaptureSprites/femaleCaptureAtlas.atlas"));
                moveAnimation = new Animation(1 / 20f, moveTextureAtlas.getRegions());
                isVisible=false;
                isChosen=true;
                if(!isMade) {
                    for (int i = 0; i < 3; i++) {
                        list.add(new pokemonActor());
                        stage.addActor(list.get(i));
                        isMade = true;
                    }
                }
                return true;
            }
        });
        stage.addActor(femaleBtn);

        ImageButton maleBtn = new ImageButton(mySkin2);
        maleBtn.setSize(col_width*4,(float)(row_height*2));
        maleBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("maleSpritePics/tile000.png"))));
        maleBtn.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("maleSpritePics/tile000.png"))));
        maleBtn.setPosition(col_width,Gdx.graphics.getHeight()-row_height*6);
        maleBtn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                textureAtlas = new TextureAtlas(Gdx.files.internal("maleSprites/maleAtlas.atlas"));
                stillAnimation = new Animation(1 / 10f, textureAtlas.getRegions());
                moveTextureAtlas = new TextureAtlas(Gdx.files.internal("maleCaptureSprites/maleCaptureAtlas.atlas"));
                moveAnimation = new Animation(1 / 20f, moveTextureAtlas.getRegions());
                isVisible=false;
                isChosen=true;
                if(!isMade) {
                    for (int i = 0; i < 3; i++) {
                        list.add(new pokemonActor());
                        stage.addActor(list.get(i));
                        isMade = true;
                    }
                }
                return true;
            }
        });
        stage.addActor(maleBtn);

        ImageButton upBtn = new ImageButton(mySkin3);
        upBtn.setSize(col_width*2,(float)(row_height*2));
        upBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("up.png"))));
        upBtn.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("up.png"))));
        upBtn.setPosition(col_width*5,Gdx.graphics.getHeight()-row_height*8);
        upBtn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                if(yVal==250){
                    yVal=375;
                }else if(yVal==125){
                    yVal=250;
                }
                return true;
            }
        });
        stage.addActor(upBtn);

        ImageButton downBtn = new ImageButton(mySkin4);
        downBtn.setSize(col_width*2,(float)(row_height*2));
        downBtn.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("down.png"))));
        downBtn.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("down.png"))));
        downBtn.setPosition(col_width*5,Gdx.graphics.getHeight()-row_height*10);
        downBtn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
               if(yVal==250){
                   yVal=125;
               }else if(yVal==375){
                   yVal=250;
               }
                return true;
            }
        });
        stage.addActor(downBtn);

        backTextureAtlas = new TextureAtlas(Gdx.files.internal("backgroundSprites/backgroundAtlas.atlas"));
        backTextureRegion = backTextureAtlas.findRegion("tile000");
        backSprite = new Sprite(backTextureRegion);
        backSprite.setPosition(-100,0);
        backSprite.setSize(1600, 2500);
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(8f);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(Color.WHITE.r, Color.WHITE.g, Color.WHITE.b, Color.WHITE.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		timeForStill += Gdx.graphics.getDeltaTime();
		batch.begin();
		stage.act();
		if(backFrame<10) {
            backSprite.setRegion(backTextureAtlas.findRegion("tile00" + Integer.toString(backFrame)));
        }else{
            backSprite.setRegion(backTextureAtlas.findRegion("tile0" + Integer.toString(backFrame)));
        }

        backSprite.draw(batch);
        backFrame++;
        if (backFrame == 65)
            backFrame = 0;
        if(!isVisible) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getX() > 1440) {
                    list.remove(i);
                    list.add(new pokemonActor());
                    stage.addActor(list.get(list.size() - 1));
                }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i).getX()>=1200 && list.get(i).getX()<=1205 && list.get(i).getY()>=yVal &&list.get(i).getY()<=(yVal+150)){
                    caught=true;
                    Gdx.app.log("hi",score+"");
                }
            }
        }
        if(isChosen){
            if(caught){
                Gdx.app.log("hi",score+"");
                batch.draw(moveAnimation.getKeyFrame(timeForStill, false), 1200, yVal);
                score++;
                caught=false;
            }else {
                Gdx.app.log("hi","Nope");
                batch.draw(stillAnimation.getKeyFrame(timeForStill, true), 1200, yVal);
            }
        }
        bitmapFont.draw(batch,score+"",720,2000);
		batch.end();
        stage.draw();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}