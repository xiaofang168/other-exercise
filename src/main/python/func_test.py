# coding=UTF-8
import sys
from typing import *
from collections import defaultdict
sys.version
import requests
import pprint
from timeit import default_timer as timer
from time import sleep

url = 'https://randomuser.me/api/?results=1'
users = requests.get(url).json()
pprint.pprint(users)

import uuid
user_id = uuid.uuid4()
print(user_id)

'''
高阶函数调用
'''
# define a function on-the-fly
pow2 = lambda x: x**2
print(pow2(2))

# take a function as a parameter
def print_twice(func: Callable, arg: Any):
    print(func(arg))
    print(func(arg))
print_twice(pow2, 3)

# take a function as a parameter and return a new function
def hello():
    print('Hello world!')
def loop(func: Callable, n: int):
    for _ in range(n):
        func()
loop(hello, 3)

def measure(func: Callable):
    def inner(*args, **kwargs):
        print(f'---> Calling {func.__name__}()')
        start = timer()
        func(*args, **kwargs)
        elapsed_sec = timer() - start
        print(f'---> Done {func.__name__}(): {elapsed_sec:.3f} secs')
    return inner

def sleeper(seconds: int = 0):
    print('Going to sleep...')
    sleep(seconds)
    print('Done!')
    

measured_sleeper = measure(sleeper)
measured_sleeper(3)


def repeat(n: int = 1):
    def decorator(func: Callable):
        def inner(*args, **kwargs):
            for _ in range(n):
                func(*args, **kwargs)
        return inner
    return decorator

@repeat(n=3)
def hello(name: str):
    print(f'Hello {name}!')
    
hello('世界')