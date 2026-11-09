class Solution(object):
    def busiestServers(self, k, arrival, load):
        """
        :type k: int
        :type arrival: List[int]
        :type load: List[int]
        :rtype: List[int]
        """
        available = SortedList(range(k))

        # (finish_time, server_id)
        busy = []

        count = [0] * k

        for i in range(len(arrival)):

            # Release completed servers
            while busy and busy[0][0] <= arrival[i]:
                finish, server = heapq.heappop(busy)
                available.add(server)

            if not available:
                continue

            start = i % k

            # Find first available server >= start
            idx = available.bisect_left(start)

            # Wrap around
            if idx == len(available):
                idx = 0

            server = available.pop(idx)

            count[server] += 1

            heapq.heappush(
                busy,
                (arrival[i] + load[i], server)
            )

        maximum = max(count)

        return [
            i for i in range(k)
            if count[i] == maximum
        ]