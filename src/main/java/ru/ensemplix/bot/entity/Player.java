package ru.ensemplix.bot.entity;

import java.util.UUID;

/**
 * Представляет из себя игрока на сервере.
 */
public class Player extends Entity {

    /**
     * Уникальный индификатор игрока.
     */
    private UUID playerId;

    /**
     * Текущий предмет у игрока в руке.
     */
    private int currentItem;

    public Player(int entityId, UUID playerId) {
        super(entityId);

        this.playerId = playerId;
    }

    /**
     * Уникальный индификатор игрока.
     */
    public UUID getPlayerId() {
       return playerId;
    }

    /**
     * Установить текущий предмет игрока в руке.
     */
    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    /**
     * Текущий предмет у игрока в руке.
     */
    public int getCurrentItem() {
        return currentItem;
    }

}
