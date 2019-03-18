package com.company;

public class Mother {
//protected : члены класса доступны внутри пакета и в классах наследниках
        public static void main(String[] args) {
            Mother daughter = new Daughter();
        daughter.go();

        }
        protected void go() {
            System.out.println("Я пойду в класс с мамой");
       }
    }
    class Daughter extends Mother {
        @Override
        public void go () {
            System.out.println("Я пойду в класс сама");
        }

    }

