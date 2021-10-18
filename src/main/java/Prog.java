import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

public class Prog {

    private static final String URL = "jdbc:postgresql://localhost:5432/ex4";
    private static final String USER = "PLACEHOLDER";
    private static final String PASSWORD = "PLACEHOLDER";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Tree> index() {
        List<Tree> treeNodes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM tree";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Tree treeNode = new Tree();

                treeNode.setId(resultSet.getInt("id"));
                treeNode.setParentId((Integer) resultSet.getObject("parent_id"));
                treeNode.setName(resultSet.getString("name"));
                treeNode.setLayer((int) treeNode.getName().chars().filter(ch -> ch == '.').count() + 1);

                treeNodes.add(treeNode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treeNodes;
    }

    public static void traversal(Tree tree) {
        if (tree == null) {
            return;
        }
        String dash = "-";
        System.out.println(dash.repeat(tree.getLayer()) + tree.getName());
        traversal(tree.getFirstChild());
        traversal(tree.getRightNeighbour());
    }

    public static void main(String[] args) {
        Set<Integer> processedNodes = new HashSet<>();
        List<Tree> listFromDB = new ArrayList<>(index());

        Collections.sort(listFromDB);

        for(Tree node : listFromDB){

            node.setFirstChild(listFromDB.stream()
                    .filter(tree -> Objects.equals(tree.getParentId(), node.getId())).findFirst().orElse(null));

            node.setRightNeighbour(listFromDB.stream()
                    .filter(tree -> Objects.equals(tree.getParentId(), node.getParentId())
                            && !processedNodes.contains(tree.getId())
                            && tree.getId() != node.getId()).findFirst().orElse(null));

            processedNodes.add(node.getId());
        }

        traversal(listFromDB.stream()
                .filter(tree -> Objects.equals(tree.getParentId(), null)).findFirst().orElse(null));
    }
}
