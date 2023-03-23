package pers.chris.DFS.ThroneInheritance;

import java.util.*;

class ThroneInheritance {

    // 血缘关系
    Map<String, List<String>> edges;
    // 死亡名单
    Set<String> dead;
    String king;

    public ThroneInheritance(String kingName) {
        edges = new HashMap<>();
        dead = new HashSet<>();
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        edges.put(parentName, children);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(res, king);
        return res;
    }

    private void dfs(List<String> res, String name) {
        if (!dead.contains(name)) {
            res.add(name);
        }

        List<String> children = edges.getOrDefault(name, new ArrayList<String>());
        for (String child: children) {
            dfs(res, child);
        }
    }
}
