package com.malaikachandler.tt.carddata;

import com.malaikachandler.tt.Card;
import com.malaikachandler.tt.Elemental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardData {

    private static CardData instance;

    public static CardData getInstance() {
        if (instance == null) {
            instance = new CardData();
        }
        return instance;
    }

    private static Map<Integer, ArrayList<Card>> cards = new HashMap<>();

    public static ArrayList<Card> getCardsAtLevel(int level) {
        if (cards.containsKey(level)) {
            return cards.get(level);
        }
        return null;
    }

    private CardData() {
        cards.put(1, new ArrayList<>());
        cards.put(2, new ArrayList<>());
        cards.put(3, new ArrayList<>());
        cards.put(4, new ArrayList<>());
        cards.put(5, new ArrayList<>());
        cards.put(6, new ArrayList<>());
        cards.put(7, new ArrayList<>());
        cards.put(8, new ArrayList<>());
        cards.put(9, new ArrayList<>());
        cards.put(10, new ArrayList<>());

        cards.get(1).add(new Card("Geezard", 1, 5, 4, 1, Elemental.NONE, 1));
        cards.get(1).add(new Card("Funguar", 5, 3, 1, 1, Elemental.NONE, 1));
        cards.get(1).add(new Card("Bite Bug", 1, 5, 3, 3, Elemental.NONE, 1));
        cards.get(1).add(new Card("Red Bat", 6, 2, 1, 1, Elemental.NONE, 1));
        cards.get(1).add(new Card("Blobra", 2, 5, 3, 1, Elemental.NONE, 1));
        cards.get(1).add(new Card("Gayla", 2, 4, 1, 4, Elemental.THUNDER, 1));
        cards.get(1).add(new Card("Gesper", 1, 1, 5, 4, Elemental.NONE, 1));
        cards.get(1).add(new Card("Fastitocalon-F", 3, 1, 5, 2, Elemental.EARTH, 1));
        cards.get(1).add(new Card("Blood Soul", 2, 1, 1, 6, Elemental.NONE, 1));
        cards.get(1).add(new Card("Caterchipillar", 4, 3, 2, 4, Elemental.NONE, 1));
        cards.get(1).add(new Card("Cockatrice", 2, 6, 1, 2, Elemental.THUNDER, 1));

        cards.get(2).add(new Card("Grat", 7, 1, 1, 3, Elemental.NONE, 2));
        cards.get(2).add(new Card("Buel", 6, 3, 2, 2, Elemental.NONE, 2));
        cards.get(2).add(new Card("Mesmerize", 5, 4, 3, 3, Elemental.NONE, 2));
        cards.get(2).add(new Card("Glacial Eye", 6, 3, 1, 4, Elemental.ICE, 2));
        cards.get(2).add(new Card("Belhelmel", 3, 3, 4, 5, Elemental.NONE, 2));
        cards.get(2).add(new Card("Thrustaevis", 5, 5, 3, 2, Elemental.WIND, 2));
        cards.get(2).add(new Card("Anacondaur", 5, 5, 1, 3, Elemental.POISON, 2));
        cards.get(2).add(new Card("Creeps", 5, 2, 2, 5, Elemental.THUNDER, 2));
        cards.get(2).add(new Card("Grendel", 4, 2, 4, 5, Elemental.THUNDER, 2));
        cards.get(2).add(new Card("Jelleye", 3, 7, 2, 1, Elemental.NONE, 2));
        cards.get(2).add(new Card("Grand Mantis", 5, 3, 2, 5, Elemental.NONE, 2));

        cards.get(3).add(new Card("Forbidden", 6, 2, 6, 3, Elemental.NONE, 3));
        cards.get(3).add(new Card("Armadodo", 6, 6, 3, 1, Elemental.EARTH, 3));
        cards.get(3).add(new Card("Tri-Face", 3, 5, 5, 5, Elemental.POISON, 3));
        cards.get(3).add(new Card("Fastitocalon", 7, 3, 5, 1, Elemental.EARTH, 3));
        cards.get(3).add(new Card("Snow Lion", 7, 3, 1, 5, Elemental.ICE, 3));
        cards.get(3).add(new Card("Ochu", 5, 3, 6, 3, Elemental.NONE, 3));
        cards.get(3).add(new Card("SAM08G", 5, 4, 6, 2, Elemental.FIRE, 3));
        cards.get(3).add(new Card("Death Claw", 4, 2, 4, 7, Elemental.FIRE, 3));
        cards.get(3).add(new Card("Cactuar", 6, 3, 2, 6, Elemental.NONE, 3));
        cards.get(3).add(new Card("Tonberry", 3, 4, 6, 4, Elemental.NONE, 3));
        cards.get(3).add(new Card("Abyss Worm", 7, 5, 2, 3, Elemental.EARTH, 3));

        cards.get(4).add(new Card("Turtapod", 2, 7, 3, 6, Elemental.NONE, 4));
        cards.get(4).add(new Card("Vysage", 6, 5, 5, 4, Elemental.NONE, 4));
        cards.get(4).add(new Card("T-Rexaur", 4, 7, 6, 2, Elemental.NONE, 4));
        cards.get(4).add(new Card("Bomb", 2, 3, 7, 6, Elemental.FIRE, 4));
        cards.get(4).add(new Card("Blitz", 1, 7, 6, 4, Elemental.THUNDER, 4));
        cards.get(4).add(new Card("Wendigo", 7, 6, 3, 1, Elemental.NONE, 4));
        cards.get(4).add(new Card("Torama", 7, 4, 4, 4, Elemental.NONE, 4));
        cards.get(4).add(new Card("Imp", 3, 6, 7, 3, Elemental.NONE, 4));
        cards.get(4).add(new Card("Blue Dragon", 6, 3, 2, 7, Elemental.POISON, 4));
        cards.get(4).add(new Card("Adamantoise", 4, 6, 5, 5, Elemental.EARTH, 4));
        cards.get(4).add(new Card("Hexadragon", 7, 3, 5, 4, Elemental.FIRE, 4));

        cards.get(5).add(new Card("Iron Giant", 6, 5, 5, 6, Elemental.NONE, 5));
        cards.get(5).add(new Card("Behemoth", 3, 7, 6, 5, Elemental.NONE, 5));
        cards.get(5).add(new Card("Chimera", 7, 3, 6, 5, Elemental.WATER, 5));
        cards.get(5).add(new Card("PuPu", 3, 1, 10, 2, Elemental.NONE, 5));
        cards.get(5).add(new Card("Elastoid", 6, 7, 2, 6, Elemental.NONE, 5));
        cards.get(5).add(new Card("GIM47N", 5, 4, 5, 7, Elemental.NONE, 5));
        cards.get(5).add(new Card("Malboro", 7, 2, 7, 4, Elemental.POISON, 5));
        cards.get(5).add(new Card("Ruby Dragon", 7, 4, 2, 7, Elemental.FIRE, 5));
        cards.get(5).add(new Card("Elnoyle", 5, 6, 3, 7, Elemental.NONE, 5));
        cards.get(5).add(new Card("Tonberry King", 4, 4, 6, 7, Elemental.NONE, 5));
        cards.get(5).add(new Card("Biggs, Wedge", 6, 7, 6, 2, Elemental.NONE, 5));

        cards.get(6).add(new Card("Fujin, Raijin", 2, 4, 8, 8, Elemental.NONE, 6));
        cards.get(6).add(new Card("Elvoret", 7, 4, 8, 3, Elemental.WIND, 6));
        cards.get(6).add(new Card("X-ATM092", 4, 3, 8, 7, Elemental.NONE, 6));
        cards.get(6).add(new Card("Granaldo", 7, 5, 2, 8, Elemental.NONE, 6));
        cards.get(6).add(new Card("Gerogero", 1, 3, 8, 8, Elemental.POISON, 6));
        cards.get(6).add(new Card("Iguion", 8, 2, 2, 8, Elemental.NONE, 6));
        cards.get(6).add(new Card("Abadon", 6, 5, 8, 4, Elemental.NONE, 6));
        cards.get(6).add(new Card("Trauma", 4, 6, 8, 5, Elemental.NONE, 6));
        cards.get(6).add(new Card("Oilboyle", 1, 8, 8, 4, Elemental.NONE, 6));
        cards.get(6).add(new Card("Shumi Tribe", 6, 4, 5, 8, Elemental.NONE, 6));
        cards.get(6).add(new Card("Krysta", 7, 1, 5, 8, Elemental.NONE, 6));

        cards.get(7).add(new Card("Propagator", 8, 8, 4, 4, Elemental.NONE, 7));
        cards.get(7).add(new Card("Jumbo Cactuar", 8, 4, 8, 4, Elemental.NONE, 7));
        cards.get(7).add(new Card("Tri-Point", 8, 8, 5, 2, Elemental.THUNDER, 7));
        cards.get(7).add(new Card("Gargantua", 5, 8, 6, 6, Elemental.NONE, 7));
        cards.get(7).add(new Card("Mobile Type 8", 8, 3, 6, 7, Elemental.NONE, 7));
        cards.get(7).add(new Card("Sphinxara", 8, 8, 3, 5, Elemental.NONE, 7));
        cards.get(7).add(new Card("Tiamat", 8, 4, 8, 5, Elemental.NONE, 7));
        cards.get(7).add(new Card("BGH251F2", 5, 5, 7, 8, Elemental.NONE, 7));
        cards.get(7).add(new Card("Red Giant", 6, 7, 8, 4, Elemental.NONE, 7));
        cards.get(7).add(new Card("Catoblepas", 1, 7, 8, 7, Elemental.NONE, 7));
        cards.get(7).add(new Card("Ultima Weapon", 7, 8, 7, 2, Elemental.NONE, 7));

        cards.get(8).add(new Card("Chubby Chocobo", 4, 9, 4, 8, Elemental.NONE, 8));
        cards.get(8).add(new Card("Angelo", 9, 3, 6, 7, Elemental.NONE, 8));
        cards.get(8).add(new Card("Gilgamesh", 3, 6, 7, 9, Elemental.NONE, 8));
        cards.get(8).add(new Card("MiniMog", 9, 2, 3, 9, Elemental.NONE, 8));
        cards.get(8).add(new Card("Chocobo", 9, 4, 4, 8, Elemental.NONE, 8));
        cards.get(8).add(new Card("Quezacotl", 2, 4, 9, 9, Elemental.THUNDER, 8));
        cards.get(8).add(new Card("Shiva", 6, 9, 7, 4, Elemental.ICE, 8));
        cards.get(8).add(new Card("Ifrit", 9, 8, 6, 2, Elemental.FIRE, 8));
        cards.get(8).add(new Card("Siren", 8, 2, 9, 6, Elemental.NONE, 8));
        cards.get(8).add(new Card("Sacred", 5, 9, 1, 9, Elemental.EARTH, 8));
        cards.get(8).add(new Card("Minotaur", 9, 9, 5, 2, Elemental.EARTH, 8));

        cards.get(9).add(new Card("Carbuncle", 8, 4, 4, 10, Elemental.NONE, 9));
        cards.get(9).add(new Card("Diablos", 5, 3, 10, 8, Elemental.NONE, 9));
        cards.get(9).add(new Card("Leviathan", 7, 7, 10, 1, Elemental.WATER, 9));
        cards.get(9).add(new Card("Odin", 8, 5, 10, 3, Elemental.NONE, 9));
        cards.get(9).add(new Card("Pandemona", 10, 7, 1, 7, Elemental.WIND, 9));
        cards.get(9).add(new Card("Cerberus", 7, 10, 4, 6, Elemental.NONE, 9));
        cards.get(9).add(new Card("Alexander", 9, 2, 10, 4, Elemental.HOLY, 9));
        cards.get(9).add(new Card("Phoenix", 7, 10, 2, 7, Elemental.FIRE, 9));
        cards.get(9).add(new Card("Bahamut", 10, 6, 8, 2, Elemental.NONE, 9));
        cards.get(9).add(new Card("Doomtrain", 3, 10, 1, 10, Elemental.POISON, 9));
        cards.get(9).add(new Card("Eden", 4, 10, 4, 9, Elemental.NONE, 9));

        cards.get(10).add(new Card("Ward", 10, 8, 7, 2, Elemental.NONE, 10));
        cards.get(10).add(new Card("Kiros", 6, 10, 7, 6, Elemental.NONE, 10));
        cards.get(10).add(new Card("Laguna", 5, 9, 10, 3, Elemental.NONE, 10));
        cards.get(10).add(new Card("Selphie", 10, 4, 8, 6, Elemental.NONE, 10));
        cards.get(10).add(new Card("Quistis", 9, 2, 6, 10, Elemental.NONE, 10));
        cards.get(10).add(new Card("Irvine", 2, 10, 6, 9, Elemental.NONE, 10));
        cards.get(10).add(new Card("Zell", 8, 6, 5, 10, Elemental.NONE, 10));
        cards.get(10).add(new Card("Rinoa", 4, 10, 10, 2, Elemental.NONE, 10));
        cards.get(10).add(new Card("Edea", 10, 3, 10, 3, Elemental.NONE, 10));
        cards.get(10).add(new Card("Seifer", 6, 4, 9, 10, Elemental.NONE, 10));
        cards.get(10).add(new Card("Squall", 10, 9, 4, 6, Elemental.NONE, 10));
    }
}
