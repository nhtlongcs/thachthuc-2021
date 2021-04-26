import re

import csv


def flatten(row: int, col: int, num_cols=8):
    return row * num_cols + col


if __name__ == "__main__":
    table = None
    with open("adapter.out", "r") as f:
        inp_str = f.readline()
        print(inp_str)
        num_cols = 7
        num_rows = len(inp_str) // num_cols + 1
        table = [x[:] for x in [[None] * num_cols] * num_rows]
        print(len(inp_str))
        print(num_rows, " ", num_cols)
        for row_id in range(num_rows):
            for col_id in range(num_cols):
                flatten_id = flatten(row=row_id, col=col_id)
                if flatten_id > len(inp_str) - 1:
                    continue
                table[row_id][col_id] = inp_str[flatten_id]

    with open("output.csv", "w", newline="") as f:
        writer = csv.writer(f)
        writer.writerows(table)
