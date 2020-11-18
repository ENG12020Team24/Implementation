package io.github.eng12020team24.project1.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Beam{
    public static final int SPEED = 8;
    private static TextureRegion texture;
    float xDir;
    float yDir;
    int xPos;
    int yPos;
    public boolean remove = false;

    public Beam(int rotation, TextureAtlas atlas){
        int xPos = Gdx.graphics.getHeight()/2;
        int yPos = Gdx.graphics.getHeight()/2;
        xDir = Math.round(SPEED*32*Math.cos(Math.toRadians(rotation-90)));
        yDir = Math.round(SPEED*32*Math.sin(Math.toRadians(rotation-90)));
        texture = new TextureRegion(atlas.findRegion("Z_BEAM_ORB"));
    }

    public void move(float deltaTime){
        xPos += xDir*deltaTime;
        yPos += yPos*deltaTime;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, xPos,yPos);
    }

    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }


}