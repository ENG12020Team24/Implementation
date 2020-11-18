package io.github.eng12020team24.project1.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import io.github.eng12020team24.project1.characters.character_utils;
import io.github.eng12020team24.project1.mapclasses.TileType;

public class StationSystem {
    private int xPos;
    private int yPos;
    private int health;
    private boolean functioning;
    private TextureRegion systemOn;
    private TextureRegion systemOff;

    public StationSystem(TextureAtlas atlas, int x, int y){
        systemOn = new TextureRegion(atlas.findRegion("Z_SYSTEM_OK"));
        systemOff = new TextureRegion(atlas.findRegion("Z_SYSTEM_OFF"));
        functioning = true;
        xPos = x * TileType.TILE_SIZE;
        yPos = y * TileType.TILE_SIZE;
        health = 10;
    }

    public int getHealth(){
        return health;
    }

    public void takeDamage(){
       if (health > 0){
           health -= 1;
           functioning = false;
       }
    }

    public void render(SpriteBatch batch, OrthographicCamera camera){
        Vector2 cameraRelativeLocation = character_utils.worldPositionToCameraPosition(camera, new Vector2(xPos,yPos));
        if (functioning){
            batch.draw(systemOn,cameraRelativeLocation.x,cameraRelativeLocation.y);
        } else {
            batch.draw(systemOff,cameraRelativeLocation.x,cameraRelativeLocation.y);
        }
    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }


}