import random

from tqdm import tqdm

data_dict = {}
with open("dict.dat", "r") as f:
    data = f.readlines()
    for line in data:
        if len(line.split()) != 2:
            continue
        key, value = line.split()
        key = key.lower()
        data_dict[key] = data_dict.get(key, set())
        data_dict[key].add(value)


def get_random_token(token: str) -> str:
    global data_dict
    token = token.lower()
    if token in data_dict.keys():
        return random.choice(list(data_dict[token]))
    else:
        return token


with open("input.txt", "r") as f, open("output.txt", "w") as g:
    data = f.readlines()
    for line in data:
        line = line.split("\n")[0]
        newline = "".join([get_random_token(x) for x in line])
        g.write(newline + "\n")
