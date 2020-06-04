package Ccode;

public class MatchedGotoLabelPair {
    private int startGotoIndex;
    private int endGotoIndex;
    private int startLabelIndex;
    private int endLabelIndex;
    private String conditional;
    private String label;
    private boolean gotoBeforeLabel;
    private int matchesInside;

    public MatchedGotoLabelPair(int startGotoIndex, int endGotoIndex, int startLabelIndex, int endLabelIndex, String conditional, String label) {
        this.startGotoIndex = startGotoIndex;
        this.endGotoIndex = endGotoIndex;
        this.startLabelIndex = startLabelIndex;
        this.endLabelIndex = endLabelIndex;
        this.conditional = conditional;
        this.label = label;
        if(startGotoIndex < startLabelIndex) gotoBeforeLabel = true;
        else gotoBeforeLabel = false;
    }

    public int getStartGotoIndex() {
        return startGotoIndex;
    }

    public void setStartGotoIndex(int startGotoIndex) {
        this.startGotoIndex = startGotoIndex;
    }

    public int getEndGotoIndex() {
        return endGotoIndex;
    }

    public void setEndGotoIndex(int endGotoIndex) {
        this.endGotoIndex = endGotoIndex;
    }

    public int getStartLabelIndex() {
        return startLabelIndex;
    }

    public void setStartLabelIndex(int startLabelIndex) {
        this.startLabelIndex = startLabelIndex;
    }

    public int getEndLabelIndex() {
        return endLabelIndex;
    }

    public void setEndLabelIndex(int endLabelIndex) {
        this.endLabelIndex = endLabelIndex;
    }

    public boolean isGotoBeforeLabel() {
        return gotoBeforeLabel;
    }

    public void setGotoBeforeLabel(boolean gotoBeforeLabel) {
        this.gotoBeforeLabel = gotoBeforeLabel;
    }


    public int getMatchesInside() {
        return matchesInside;
    }

    public void setMatchesInside(int matchesInside) {
        this.matchesInside = matchesInside;
    }
}
