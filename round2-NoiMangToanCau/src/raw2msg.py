import random
from tqdm import tqdm
import argparse

data_dict = {}
l = 1
r = 255

parser = argparse.ArgumentParser(description='Process some integers.')
parser.add_argument('--inp-path', default='./example/inp.txt',
                    help='description')
parser.add_argument('--dict-path', default='./meta/dict.dat',
                    help='description')
parser.add_argument('--out-path', default='./example/ans.txt',
                    help='description')
args = parser.parse_args()

with open(args.dict_path, "r") as f:
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


def get_random_key(l: int, r: int) -> int:
    return str(random.randint(l, r))


print(args)
with open(args.inp_path, "r") as f, open(args.out_path, "w") as g:
    data = f.readlines()
    for line in tqdm(data):
        line = line.split("\n")[0]
        newline = "".join([get_random_token(x) for x in line])
        g.write(newline + "\n")
        g.write(get_random_key(l, r) + "\n")
    g.write("0")
