package amerika.nodes.twowaybitreenode;

import amerika.nodes.bitreenode.BinaryTreeNode;

public class TwoWayBinaryTreeNode extends BinaryTreeNode {

    private TwoWayBinaryTreeNode parent;
    private boolean red;

    public TwoWayBinaryTreeNode(char key) {
        super(key);
    }

    public void setParent(TwoWayBinaryTreeNode parent) {
        this.parent = parent;
    }

    public TwoWayBinaryTreeNode getParent(){
        return parent;
    } 

    public void setRed(boolean isRed){
        this.red = isRed;
    }

    public boolean isRed(){
        return red;
    }
}
