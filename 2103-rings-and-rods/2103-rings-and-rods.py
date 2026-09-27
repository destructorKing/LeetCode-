class Solution:
    def countPoints(self, rings: str) -> int:
        rods = {}
        for i in range(0, len(rings), 2):
            color, rod = rings[i], rings[i+1]
            if rod not in rods:
                rods[rod] = set()
            rods[rod].add(color)
        
        return sum(1 for colors in rods.values() if len(colors) == 3)