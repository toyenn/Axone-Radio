/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.Calendar;

/**
 *
 * @author Nathan
 */
public class DateN {
     private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    public DateN(int jour, int mois, int annee) { 
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public DateN(int jour, int mois, int annee, int heure, int minute) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minute = minute;
    }
    
    public DateN(String DateBD){ // récupère la date au format de la base de données pour un patient
      
        this.annee = Integer.parseInt(DateBD.substring(0, 4));
       
        this.mois = Integer.parseInt(DateBD.substring(5, 7));
        
        this.jour = Integer.parseInt(DateBD.substring(8, 10));
      
    }

    public DateN() {// recupere la date actuelle


        java.util.Date date = new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.annee = calendar.get(Calendar.YEAR);
        this.mois = calendar.get(Calendar.MONTH);
        this.jour = calendar.get(Calendar.DAY_OF_MONTH);
        this.heure = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);

    }

    public String toString() { // format AAAA-MM-JJ HH:MN:00
        String s = "";
        s += getAnnee() + "-";
        if (getMois() < 10) {
            s += "0" + getMois() + "-";
        } else {
            s += getMois() + "-";
        }
        if (getJour() < 10) {
            s += "0" + getJour() + " ";
        } else {
            s += getJour() + " ";
        }
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute+":00";
        } else {
            s += minute+":00";
        }
        return s;
    }

    public String toString_DateNaissance() {
        String s = "";
        s += getAnnee() + "-";
        if (getMois() < 10) {
            s += "0" + getMois() + "-";
        } else {
            s += getMois() + "-";
        }
        if (getJour() < 10) {
            s += "0" + getJour();
        } else {
            s += getJour();
        }
        return s;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public String getMoisEnint(int m) {
        switch (m) {
            case 1:
                return "Janvier";
            case 2:
                return "Février";
            case 3:
                return "Mars";
            case 4:
                return "Avril";
            case 5:
                return "Mai";
            case 6:
                return "Juin";
            case 7:
                return "Juillet";
            case 8:
                return "Aout";
            case 9:
                return "Septembre";
            case 10:
                return "Octobre";
            case 11:
                return "Novembre";
            case 12:
                return "Decembre";
            default:
                return "Default";

        }
    }

    public int getAnnee() {
        return annee;
    }

    public int getHeure() {
        return heure;
    }

    public int getMinute() {
        return minute;
    }

    public boolean equals(Object o) {
        if (o instanceof DateN) {
            DateN d = (DateN) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour);
        } else {
            return false;
        }
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

   
    public int compareTo(Object o) {
        DateN d = (DateN) o;
        if (annee != d.annee) {
            return annee - d.annee;
        }
    
        if (mois != d.mois) {
            return mois - d.mois;
        }
        
        return this.jour - d.jour;
        
    }
}
