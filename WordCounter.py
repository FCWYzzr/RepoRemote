"""
最简单的大作业项目：
   词频统计
"""

from collections import Counter
from typing import Iterable
# from jieba import cut


def getTop(lst: Iterable,
           n: int = 10) -> list[tuple[str, int], ...]:
    """
    getTop(lst: Iterable [, n:int])
    :param lst: 一个可迭代对象，存储着分好的单词
    :param n: 提取前几名，可省略，默认为10
    :return: lst中排名前n位的单词
    """
    c = Counter(lst)
    return c.most_common(n)


def wordSplit(text: str) -> Iterable:
    """
    :param text: 需要被分词的文本
    :return: 分好词的可迭代对象
    """
    # return cut(text)
    for ch in ".,?!\n":
        text = text.replace(ch, ' ')
    return text.split()


def test():
    text: str = "Hi! This is my dog. That is my cat. It is great"
    words = wordSplit(text)
    top = getTop(words, 3)

    for word, times in top:
        print(f"{word} --- {times}")


if __name__ == "__main__":
    test()
