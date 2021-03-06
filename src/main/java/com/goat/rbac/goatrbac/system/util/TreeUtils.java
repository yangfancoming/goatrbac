package com.goat.rbac.goatrbac.system.util;


import com.goat.rbac.goatrbac.system.model.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtils {
	
	public static <T> Tree<T> build(List<Tree<T>> nodes) {
		if (nodes == null) return null;
		List<Tree<T>> topNodes = new ArrayList<>();
		for (Tree<T> children : nodes) {
			String pid = children.getParentId();
			if (pid == null || "0".equals(pid)) {
				topNodes.add(children);
				continue;
			}
			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setHasChildren(true);
					continue;
				}
			}
		}
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
		return new Tree<>("0","根节点",state,true,topNodes,true,"",false);
	}

}