package sample;

import  java.util.Random;

public class OpponentInput extends Combat {

    Random random = new Random();
    double swordAttackDamage = 30;
    double magicAttackDamage = 70;
    double atkBuff = 0;
    double defBuff = 0;
    int swordAttackLimit = 200;
    int magicAttackLimit = 5;
    int atkBuffLimit = 4;
    int defBuffLimit = 4;

        public void optionSelector () {
            int option = random.nextInt(22);
            if (option < 8) {
                if(swordAttackLimit>1)
                {
                    swordAttackLimit--;
                    double damage = swordAttackDamage;

                    execution.inputBucket2(1,damage,defBuff);
                }else {
                    optionSelector();
                }

             } else if (option < 14) {
                if(magicAttackLimit>1) {
                    magicAttackLimit--;
                    double damage = magicAttackDamage;

                    execution.inputBucket2(2, damage, defBuff);
                }else{
                    optionSelector();
                }

            } else if (option < 17) {
                if(atkBuffLimit>1)
                {
                    atkBuffLimit--;
                    swordAttackDamage = swordAttackDamage + swordAttackDamage*.20;
                    magicAttackDamage =  magicAttackDamage + magicAttackDamage*.20;
                    execution.inputBucket2(3,0,defBuff);
                }
                else {
                    optionSelector();
                }


            }else if(option<19){
                execution.inputBucket2(0,0,defBuff);

            }else if (option < 22) {
                if(defBuffLimit>1)
                {
                    defBuffLimit--;
                    defBuff += .10;
                    execution.inputBucket2(4,0,defBuff);
                }else{
                    optionSelector();
                }




            }
        }

}

