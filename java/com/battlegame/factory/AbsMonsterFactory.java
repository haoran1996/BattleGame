package com.battlegame.factory;

import com.battlegame.classes.Monster;

public interface AbsMonsterFactory {
    public Monster createMonster(int level);

}
