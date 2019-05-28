package com.malaikachandler.tt.gamecomponents;

public enum Position {
    TOP, LEFT, RIGHT, BOTTOM;

    public Position getOpposite() {
        switch (this) {
            case TOP: return BOTTOM;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case BOTTOM: return TOP;
        }
        return null;
    }
}
