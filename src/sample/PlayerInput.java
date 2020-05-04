package sample;

public class PlayerInput extends Combat {


    double swordAttackDamage = 30;
    double magicAttackDamage = 70;
    double atkBuff = 0;
    double defBuff = 0;
    int swordAttackLimit =200;
    int magicAttackLimit =5;
    int atkBuffLimit =4;
    int defBuffLimit =4;

    void swordAttack(){
        opponentInput.optionSelector();
        swordAttackLimit--;
        double damage = swordAttackDamage ;
        execution.inputBucket1(1,damage,defBuff);
    }
    void magicAttack(){
        opponentInput.optionSelector();
        magicAttackLimit--;
        double damage =  magicAttackDamage;
        execution.inputBucket1(2,damage,defBuff);
    }
    void buffAttack(){
        opponentInput.optionSelector();
        atkBuffLimit--;
        swordAttackDamage = swordAttackDamage + swordAttackDamage*.20;
        magicAttackDamage =  magicAttackDamage + magicAttackDamage*.20;
        execution.inputBucket1(3,0,defBuff);
    }
    void buffDefense(){
        opponentInput.optionSelector();
        defBuffLimit--;
        defBuff+=.15;
        execution.inputBucket1(4,0,defBuff);
    }
    void block(){
        opponentInput.optionSelector();
        execution.inputBucket1(0,0,defBuff);
    }

}
