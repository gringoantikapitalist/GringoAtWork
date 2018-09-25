package com.example.tequilagrexit.jde;


public class jdeLinie extends jdeEntgasungsbehälter{
    final int Faktor[] = {10, 13, 13, 13, 13, 13, 12, 12} ;
    final int Trichter[] = {350, 0, 0, 0, 0, 0, 300, 350};
    final int Strecke[] = {50, 300, 300, 400, 400, 300, 55, 100};
    int faktor;
    int trichter;
    int strecke;
    String nummer;
    String rechnenweg[];
    //jdeEntgasungsbehälter egbh[];

    jdeLinie(String nr){
         nummer = nr;
        // egbh[1] = new jdeEntgasungsbehälter();
         faktor = Faktor[(Integer.parseInt(nummer)-22)];
         trichter = Trichter[(Integer.parseInt(nummer)-22)];
         strecke = Strecke[(Integer.parseInt(nummer)-22)];
    }
    jdeLinie(){
        nummer = "22";
        // egbh[1] = new jdeEntgasungsbehälter();
        faktor = Faktor[(Integer.parseInt(nummer)-22)];
        trichter = Trichter[(Integer.parseInt(nummer)-22)];
        strecke = Strecke[(Integer.parseInt(nummer)-22)];
    }
    public void jderechnerest(){

    }


}
