"""
Title: 0-1 Knapsack

Problem:
    Given a list of items with values and weights, as well as a max weight,
    find the maximum value you can generate from items where the sum of the
    weights is less than the max.

Execution: python knapsack.py
"""
import unittest


class Item:
    """Item class for Knapsack."""

    def __init__(self, weight: int, value: int) -> None:
        self.weight = weight
        self.value = value


def naive_knapsack(items: list, weight: int) -> int:
    """
    Recursively check every combination of items by traversing list of items
    and either including or excluding each item.
    """
    return naive_knapsack_recur(items, weight, 0)


def naive_knapsack_recur(items: list, weight: int, i: int = 0) -> int:
    """Recursive helper function for naive_knapsack."""

    # Return when we reach the end of the list.
    if i == len(items):
        return 0

    # If item is heavier than remaining weight, skip item.
    if weight - items[i].weight < 0:
        return naive_knapsack_recur(items, weight, i + 1)

    # Try both including and excluding the current item.
    return max(
        naive_knapsack_recur(items, weight - items[i].weight, i + 1) + items[i].value,
        naive_knapsack_recur(items, weight, i + 1),
    )


def top_down_knapsack(items: list, weight: int) -> int:
    """Recursive solution that uses a cache to improve performance."""

    # Map: i -> weight -> value
    # Use a map instead of array because the data could be very sparse.
    cache = dict()
    return top_down_knapsack_recur(items, weight, 0, cache)


def top_down_knapsack_recur(items: list, weight: int, i: int, cache: dict) -> int:
    """Overloaded recursive function for top_down_knapsack."""

    # Return when we reach the end of the list.
    if i == len(items):
        return 0

    # Check the cache and return value if we get a hit.
    if i not in cache.keys():
        cache[i] = dict()
    cached = None
    try:
        cached = cache[i][weight]
    except:
        pass

    if cached:
        return cached

    # If item is heavier than remaining weight, skip item
    if weight - items[i].weight < 0:
        return top_down_knapsack_recur(items, weight, i + 1, cache)

    to_return = max(
        top_down_knapsack_recur(items, weight - items[i].weight, i + 1, cache)
        + items[i].value,
        top_down_knapsack_recur(items, weight, i + 1, cache),
    )

    cache[i] = {weight: to_return}
    return to_return


def bottom_up_knapsack(items: list, weight: int) -> int:
    """Iterative dynamic programming solution."""

    # cache[i][j] = max value for the first i items with a max weight of j
    cache = [[0 for x in range(weight + 1)] for y in range(len(items) + 1)]
    for i in range(1, len(items) + 1):
        for j in range(weight + 1):
            # If including item[i-1] would exceed max weight j, don't
            # include the item. Otherwise take the max value of including
            # or excluding the item.
            if items[i - 1].weight > j:
                cache[i][j] = cache[i - 1][j]
            else:
                cache[i][j] = max(
                    cache[i - 1][j],
                    cache[i - 1][j - items[i - 1].weight] + items[i - 1].value,
                )
    return cache[len(items)][weight]


class TestKnapsack(unittest.TestCase):
    def test_naive_empty_list(self):
        self.assertEqual(naive_knapsack(items=[], weight=10), 0)
        print("Naive, empty list")

    def test_top_down_empty_list(self):
        self.assertEqual(top_down_knapsack(items=[], weight=10), 0)
        print("Top-down, empty list")

    def test_bottom_up_empty_list(self):
        self.assertEqual(bottom_up_knapsack(items=[], weight=10), 0)
        print("Bottom-up, empty list")

    def test_naive_fibonacci(self):
        items = list()
        items.append(Item(1, 1))
        items.append(Item(2, 1))
        items.append(Item(3, 2))
        items.append(Item(4, 3))
        items.append(Item(5, 5))
        items.append(Item(6, 8))
        items.append(Item(7, 13))
        items.append(Item(8, 21))
        items.append(Item(9, 34))
        items.append(Item(10, 55))

        self.assertEqual(naive_knapsack(items, weight=20), 90)

    def test_top_down_fibonacci(self):
        items = list()
        items.append(Item(1, 1))
        items.append(Item(2, 1))
        items.append(Item(3, 2))
        items.append(Item(4, 3))
        items.append(Item(5, 5))
        items.append(Item(6, 8))
        items.append(Item(7, 13))
        items.append(Item(8, 21))
        items.append(Item(9, 34))
        items.append(Item(10, 55))

        self.assertEqual(top_down_knapsack(items, weight=20), 90)

    def test_bottom_up_fibonacci(self):
        items = list()
        items.append(Item(1, 1))
        items.append(Item(2, 1))
        items.append(Item(3, 2))
        items.append(Item(4, 3))
        items.append(Item(5, 5))
        items.append(Item(6, 8))
        items.append(Item(7, 13))
        items.append(Item(8, 21))
        items.append(Item(9, 34))
        items.append(Item(10, 55))

        self.assertEqual(bottom_up_knapsack(items, weight=20), 90)


if __name__ == "__main__":
    unittest.main()
