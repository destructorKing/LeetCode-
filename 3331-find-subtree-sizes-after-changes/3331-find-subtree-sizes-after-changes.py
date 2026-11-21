class Solution:
    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        
        n = len(parent)

        children = [[] for _ in range(n)]

        for i in range(1, n):
            children[parent[i]].append(i)

        new_parent = parent[:]
        last = [-1] * 26

        def dfs(node):
            c = ord(s[node]) - ord('a')

            old = last[c]

            if old != -1:
                new_parent[node] = old

            last[c] = node

            for child in children[node]:
                dfs(child)

            last[c] = old

        dfs(0)

        # Build modified tree
        new_children = [[] for _ in range(n)]

        for i in range(1, n):
            new_children[new_parent[i]].append(i)

        ans = [0] * n

        def calculate(node):
            size = 1

            for child in new_children[node]:
                size += calculate(child)

            ans[node] = size
            return size

        calculate(0)

        return ans