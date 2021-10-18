public class Tree implements Comparable<Tree>{
    private int layer;
    private int id;
    private Integer parentId;
    private String name;
    private Tree firstChild;
    private Tree rightNeighbour;

    public Tree() {

    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(Tree firstChild) {
        this.firstChild = firstChild;
    }

    public Tree getRightNeighbour() {
        return rightNeighbour;
    }

    public void setRightNeighbour(Tree rightNeighbour) {
        this.rightNeighbour = rightNeighbour;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", firstChild=" + firstChild +
                ", rightNeighbour=" + rightNeighbour +
                '}';
    }

    @Override
    public int compareTo(Tree o) {
        return getName().compareTo(o.getName());
    }
}
