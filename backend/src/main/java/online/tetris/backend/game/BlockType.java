package online.tetris.backend.game;

public enum BlockType {
    I(new String[]{"IEEE","IEEE","IEEE","IEEE"}),
    J(new String[]{"JJEE","EJEE","EJEE","EJEE"}),
    L(new String[]{"ELEE","ELEE","ELEE","LLEE"}),
    O(new String[]{"EEEE","OOEE","OOEE","EEEE"}),
    S(new String[]{"ESEE","SSEE","SEEE","EEEE"}),
    T(new String[]{"ETEE","TTEE","ETEE","EEEE"}),
    Z(new String[]{"ZEEE","ZZEE","EZEE","EEEE"});

    private final String[] shape;

    BlockType(String[] shape) {
        this.shape = shape;
    }


    public String[] getShape() {
        return shape;
    }
}
