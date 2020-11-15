package io.github.eng12020team24.project1.interfaces;

public interface Damageable {
    //boolean isBroken;
    //float currentHealth;
    public boolean isBroken();

    public void setIsBroken(boolean isBroken);

    public float getCurrentHealth();

    public void damage(float damageVal);
}