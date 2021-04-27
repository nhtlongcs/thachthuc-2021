import re

import csv


def flatten(row: int, col: int, num_cols=8):
    return row * num_cols + col


if __name__ == "__main__":
    tables = []
    with open("example/msg.txt", "r") as f:
        while True:
            table = None

            inp_str = f.readline()
            if inp_str.find('Cipher: ') == 0:
                inp_str = inp_str.split('Cipher: ')[1]
                print('='*40, '\n', inp_str)
                num_cols = 8
                num_rows = len(inp_str) // num_cols + 1
                table = [x[:] for x in [[None] * num_cols] * (num_rows + 3)]
                print('inp len', len(inp_str))
                print(f"rows: {num_rows}, cols: {num_cols}")
                for row_id in range(num_rows):
                    for col_id in range(num_cols):
                        flatten_id = flatten(row=row_id, col=col_id)
                        if flatten_id > len(inp_str) - 1:
                            continue
                        table[row_id][col_id] = inp_str[flatten_id]
                table[num_rows][0] = 'Key'
                table[num_rows+1][0] = 'Answer'
                inp_str = f.readline()
                if inp_str.find('Key: ') == 0:
                    table[num_rows][1] = int(inp_str.split('Key: ')[1])
                else:
                    assert True, 'please check file format again, missing key'
                inp_str = f.readline()
                if inp_str.find('Answer: ') == 0:
                    table[num_rows+1][1] = inp_str.split('Answer: ')[1]
                else:
                    assert True, 'please check file format again, missing answer'
                tables.append(table)

            else:
                break
    with open("output.csv", "w", newline="") as f:
        writer = csv.writer(f)
        for table in tables:
            writer.writerows(table)
