package Ccode;

public class MatchedGotoLabelPair {
    private int startGotoIndex;
    private int endGotoIndex;
    private int startLabelIndex;
    private int endLabelIndex;
    private String conditional;
    private String label;
    private String gotoSubstring;
    private String labelSubstring;
    private boolean gotoBeforeLabel;
    private int matchesInside;

    public MatchedGotoLabelPair(int startGotoIndex, int endGotoIndex, int startLabelIndex, int endLabelIndex,
                                String conditional, String label, String gotoSubstring, String labelSubstring) {
        this.startGotoIndex = startGotoIndex;
        this.endGotoIndex = endGotoIndex;
        this.startLabelIndex = startLabelIndex;
        this.endLabelIndex = endLabelIndex;
        this.conditional = conditional;
        this.label = label;
        this.gotoSubstring = gotoSubstring;
        this.labelSubstring = labelSubstring;
        if(startGotoIndex < startLabelIndex) gotoBeforeLabel = true;
        else gotoBeforeLabel = false;
    }

    public boolean isGotoBeforeLabel() {
        return gotoBeforeLabel;
    }

    public int getMatchesInside() {
        return matchesInside;
    }

    public void setMatchesInside(int matchesInside) {
        this.matchesInside = matchesInside;
    }

    public String getConditional() {
        return conditional;
    }

    public String getGotoSubstring() {
        return gotoSubstring;
    }

    public String getLabelSubstring() {
        return labelSubstring;
    }
    }
