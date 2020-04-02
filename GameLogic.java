/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
import java.util.Random;
import java.util.*;
public class Game 
{
    public static void main(String[] args)
    {
        int flag=0;
        String s1="Sword Attack";
        String s2="Magic Attack";
        String s3="Attack Buff";
        String s4="Defend Buff";
        String s5="Block";
        int UserHealth=200;
        int BotHealth=200;
        int UserSwordAttackDamage=10;
        int UserMagicAttackDamage =25;
        int BotSwordAttackDamage=10;
        int BotMagicAttackDamage=25;
        int UserSwordAttackLimit =120;
        int BotSwordAttackLimit=120;
        int UserMagicAttackLimit=5;
        int BotMagicAttackLimit=5;
        int UserAttackBuffLimit =4;
        int BotAttackBuffLimit=4;
        int UserDefendBuffLimit=4;
        int BotDefendBuffLimit=4;
        int UserBlockLimit=10;
        int BotBlockLimit=10;
        while(true)
        {   
            Scanner UserInput= new Scanner(System.in);
            String s;
            while(true)
            {
            s= UserInput.nextLine();
            if(s.equals(s1))
            {
              if(UserSwordAttackLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
              else
              {
                  break;
              }
            }
            else if(s.equals(s2))
            {
                if(UserMagicAttackLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
                else
              {
                  break;
              }
                
            }
            else if(s.equals(s3))
            {
               if(UserAttackBuffLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
               else
              {
                  break;
              }
            }
            else if(s.equals(s4))
            {
               if(UserDefendBuffLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              } 
               else
               {
                   break;
               }
                   
            }
            else if(s.equals(s5))
            {
                if(UserBlockLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
                else
              {
                  break;
              }
                
            }
            }
            Random fifteen = new Random();
            int number1;
            while(true)
            {
            number1=fifteen.nextInt(15)+1;
            if(number1<=5)
            {
              if(BotSwordAttackLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
              else
              {   
                  System.out.println("BOT : Sword Attack");
                  break;
              }
            }
            else if(number1>=6 && number1<=9) 
            {
                if(BotMagicAttackLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
                else
              {   
                  System.out.println("BOT : Magic Attack");
                  break;
              }
                
            }
            else if(number1>=10 && number1<=11)
            {
               if(BotAttackBuffLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              }
               else
              {   
                  System.out.println("BOT : Attack Buff");
                  break;
              }
            }
            else if(number1>=12 && number1<=13)
            {
               if(BotDefendBuffLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              } 
               else
               {   
                   System.out.println("BOT : Defend Buff");
                   break;
               }
            }
            else if(number1>=14 && number1<=15)
            {
               if(BotBlockLimit==0)
              {
                  System.out.println("Limit has been reached for this action");
              } 
               else
               {   
                   System.out.println("BOT : Block");
                   break;
               }
            }
            }
            if(s.equals(s5) && number1<14)
            {
                if(number1<=5)
                {
                    BotSwordAttackLimit--;
                    UserHealth=UserHealth-((BotSwordAttackDamage*10)/100);
                    System.out.println(BotSwordAttackLimit +" sword attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(number1>=6 && number1<=9)
                {
                    BotMagicAttackLimit--;
                    UserHealth=UserHealth-((BotMagicAttackDamage*10)/100);
                    System.out.println(BotMagicAttackLimit +" magic attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(number1>=10 && number1<=11)
                {
                    BotAttackBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage+((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage+((BotMagicAttackDamage*10)/100);
                    System.out.println(BotAttackBuffLimit +"attack buffs left -- BOT.");
                    System.out.println("Bot Current Sword Attack Damage:"+BotSwordAttackDamage );
                    System.out.println("Bot  Current Magic Attack Damage" +BotMagicAttackDamage );
                       
                }
                else if(number1>=12 && number1<=13)
                {
                    BotDefendBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage-((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage-((UserMagicAttackDamage*10)/100);
                    System.out.println(BotDefendBuffLimit +"defend buffs left -- BOT.");
                }
            }
            else if(s.equals(s5)==false && number1>=14)
            {
                if(s.equals(s1))
                {
                    UserSwordAttackLimit--;
                    BotHealth=BotHealth-((UserSwordAttackDamage*10)/100);
                    System.out.println(UserSwordAttackLimit+" sword attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                }
                else if(s.equals(s2))
                {
                    UserMagicAttackLimit--;
                    BotHealth=BotHealth-((UserMagicAttackDamage*10)/100);
                    System.out.println(UserMagicAttackLimit+" magic attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);

                }
                else if(s.equals(s3))
                {
                    UserAttackBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage+((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage+((UserMagicAttackDamage*10)/100);
                    System.out.println(UserAttackBuffLimit +"attack buffs left -- USER.");
                    System.out.println("User Current Sword Attack Damage:"+UserSwordAttackDamage );
                    System.out.println("User Current Magic Attack Damage" +UserMagicAttackDamage );
                }
                else if(s.equals(s4))
                {
                    UserDefendBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage-((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage-((BotMagicAttackDamage*10)/100);
                    System.out.println(UserDefendBuffLimit +"defend buffs left -- USER.");
                }
            }
            else if(s.equals(s5)==false && number1<14)
            {
                if(s.equals(s1) && number1<=5)
                {
                    UserSwordAttackLimit--;
                    BotHealth=BotHealth-UserSwordAttackDamage;
                    System.out.println(UserSwordAttackLimit+" sword attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotSwordAttackLimit--;
                    UserHealth=UserHealth-BotSwordAttackDamage;
                    System.out.println(BotSwordAttackLimit+" sword attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s1) && number1>=6 && number1<=9 )
                {
                    UserSwordAttackLimit--;
                    BotHealth=BotHealth-UserSwordAttackDamage;
                    System.out.println(UserSwordAttackLimit+" sword attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotMagicAttackLimit--;
                    UserHealth=UserHealth-BotMagicAttackDamage;
                    System.out.println(BotMagicAttackLimit+" magic attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s1) && number1>=10 && number1<=11 )
                {
                    UserSwordAttackLimit--;
                    BotHealth=BotHealth-UserSwordAttackDamage;
                    System.out.println(UserSwordAttackLimit+" sword attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotAttackBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage+((BotSwordAttackDamage*15)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage+((BotMagicAttackDamage*20)/100);
                    System.out.println(BotAttackBuffLimit +"attack buffs left -- BOT.");
                    System.out.println("Bot Current Sword Attack Damage:"+BotSwordAttackDamage );
                    System.out.println("Bot  Current Magic Attack Damage" +BotMagicAttackDamage );
                }
                else if(s.equals(s1) && number1>=12 && number1<=13 )
                {
                    UserSwordAttackLimit--;
                    System.out.println(UserSwordAttackLimit+" sword attacks left -- USER.");
                    BotDefendBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage-((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage-((UserMagicAttackDamage*10)/100);
                    BotHealth=BotHealth-UserSwordAttackDamage;
                    System.out.println(BotDefendBuffLimit +"defend buffs left -- BOT.");
                    System.out.println("Bot Health:" +BotHealth);
                }
                else if(s.equals(s2) && number1<=5)
                {
                    UserMagicAttackLimit--;
                    BotHealth=BotHealth-UserMagicAttackDamage;
                    System.out.println(UserMagicAttackLimit+" magic attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotSwordAttackLimit--;
                    UserHealth=UserHealth-BotSwordAttackDamage;
                    System.out.println(BotSwordAttackLimit+" sword attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s2) && number1>=6 && number1<=9)
                {
                    UserMagicAttackLimit--;
                    BotHealth=BotHealth-UserMagicAttackDamage;
                    System.out.println(UserMagicAttackLimit+" magic attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotMagicAttackLimit--;
                    UserHealth=UserHealth-BotMagicAttackDamage;
                    System.out.println(BotMagicAttackLimit+" magic attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s2) && number1>=10 && number1<=11)
                {
                    UserMagicAttackLimit--;
                    BotHealth=BotHealth-UserMagicAttackDamage;
                    System.out.println(UserMagicAttackLimit+" magic attacks left -- USER.");
                    System.out.println("Bot Health:" + BotHealth);
                    BotAttackBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage+((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage+((BotMagicAttackDamage*10)/100);
                    System.out.println(BotAttackBuffLimit +"attack buffs left -- BOT.");
                    System.out.println("Bot Current Sword Attack Damage:"+BotSwordAttackDamage );
                    System.out.println("Bot  Current Magic Attack Damage" +BotMagicAttackDamage );
                }
                else if(s.equals(s2) && number1>=12 && number1<=13)
                {
                    UserMagicAttackLimit--;
                    System.out.println(UserMagicAttackLimit+" magic attacks left -- USER.");
                    BotDefendBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage-((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage-((UserMagicAttackDamage*10)/100);
                    BotHealth=BotHealth-UserMagicAttackDamage;
                    System.out.println(BotDefendBuffLimit +"defend buffs left -- BOT.");
                    System.out.println("Bot Health:" +BotHealth);
                }
                else if(s.equals(s3) && number1<=5)
                { 
                    UserAttackBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage+((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage+((UserMagicAttackDamage*10)/100);
                    System.out.println(UserAttackBuffLimit +"attack buffs left -- USER.");
                    System.out.println("User Current Sword Attack Damage:"+UserSwordAttackDamage );
                    System.out.println("User Current Magic Attack Damage" +UserMagicAttackDamage );
                    BotSwordAttackLimit--;
                    UserHealth=UserHealth-BotSwordAttackDamage;
                    System.out.println(BotSwordAttackLimit+" sword attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s3) && number1>=6 && number1<=9 )
                {   
                    UserAttackBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage+((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage+((UserMagicAttackDamage*10)/100);
                    System.out.println(UserAttackBuffLimit +"attack buffs left -- USER.");
                    System.out.println("User Current Sword Attack Damage:"+UserSwordAttackDamage );
                    System.out.println("User Current Magic Attack Damage" +UserMagicAttackDamage );
                    BotMagicAttackLimit--;
                    UserHealth=UserHealth-BotMagicAttackDamage;
                    System.out.println(BotMagicAttackLimit+" magic attacks left -- BOT.");
                    System.out.println("User Health:" + UserHealth);
                }
                else if(s.equals(s3) && number1>=10 && number1<=11 )
                {
                    UserAttackBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage+((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage+((UserMagicAttackDamage*10)/100);
                    System.out.println(UserAttackBuffLimit +"attack buffs left -- USER.");
                    System.out.println("User Current Sword Attack Damage:"+UserSwordAttackDamage );
                    System.out.println("User Current Magic Attack Damage" +UserMagicAttackDamage );
                    BotAttackBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage+((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage+((BotMagicAttackDamage*10)/100);
                    System.out.println(BotAttackBuffLimit +"attack buffs left -- BOT.");
                    System.out.println("Bot Current Sword Attack Damage:"+BotSwordAttackDamage );
                    System.out.println("Bot  Current Magic Attack Damage" +BotMagicAttackDamage );
                }
                else if(s.equals(s3) && number1>=12 && number1<=13 )
                {
                    UserAttackBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage+((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage+((UserMagicAttackDamage*10)/100);
                    System.out.println(UserAttackBuffLimit +"attack buffs left -- USER.");
                    System.out.println("User Current Sword Attack Damage:"+UserSwordAttackDamage );
                    System.out.println("User Current Magic Attack Damage" +UserMagicAttackDamage );
                    BotDefendBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage-((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage-((UserMagicAttackDamage*10)/100);
                    System.out.println(BotDefendBuffLimit +"defend buffs left -- BOT.");
                }
                else if(s.equals(s4) && number1<=5)
                {
                   UserDefendBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage-((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage-((BotMagicAttackDamage*10)/100);
                    UserHealth=UserHealth-BotSwordAttackDamage;
                    System.out.println(UserDefendBuffLimit +"defend buffs left -- USER.");
                    System.out.println("User Health:" + UserHealth);
                    BotSwordAttackLimit--;
                    System.out.println(BotSwordAttackLimit+" sword attacks left -- BOT.");
                }
                else if(s.equals(s4) && number1>=6 && number1<=9 )
                {    
                    UserDefendBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage-((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage-((BotMagicAttackDamage*10)/100);
                    UserHealth=UserHealth-BotMagicAttackDamage;
                    System.out.println(UserDefendBuffLimit +"defend buffs left -- USER.");
                    System.out.println("User Health:" + UserHealth);
                    BotMagicAttackLimit--;
                    System.out.println(BotMagicAttackLimit+" magic attacks left -- BOT.");

                }
                else if(s.equals(s4) && number1>=10 && number1<=11 )
                {
                    UserDefendBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage-((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage-((BotMagicAttackDamage*10)/100);
                    System.out.println(UserDefendBuffLimit +"defend buffs left -- USER.");
                    BotAttackBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage+((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage+((BotMagicAttackDamage*10)/100);
                    System.out.println(BotAttackBuffLimit +"attack buffs left -- BOT.");
                    System.out.println("Bot Current Sword Attack Damage:"+BotSwordAttackDamage );
                    System.out.println("Bot  Current Magic Attack Damage" +BotMagicAttackDamage );
                }
                else if(s.equals(s4) && number1>=12 && number1<=13 )
                {
                    UserDefendBuffLimit--;
                    BotSwordAttackDamage=BotSwordAttackDamage-((BotSwordAttackDamage*10)/100);
                    BotMagicAttackDamage=BotMagicAttackDamage-((BotMagicAttackDamage*10)/100);
                    System.out.println(UserDefendBuffLimit +"defend buffs left -- USER.");
                    BotDefendBuffLimit--;
                    UserSwordAttackDamage=UserSwordAttackDamage-((UserSwordAttackDamage*10)/100);
                    UserMagicAttackDamage=UserMagicAttackDamage-((UserMagicAttackDamage*10)/100);
                    System.out.println(BotDefendBuffLimit +"defend buffs left -- BOT.");
                }
            }
            else
            {
                System.out.println("NO DAMAGE HAPPENED TO ANYONE");
            }
            if(UserHealth==0 && BotHealth!=0)
            {
                System.out.println("ALAS!!YOU LOST!!");
                break;
            }
            else if(UserHealth!=0 && BotHealth==0)
            {
                System.out.println("HURRAY!!YOU'VE WON THE GAME!!");
                break;
            }
               
        }
    }
}
