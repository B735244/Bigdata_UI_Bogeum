import mymath
import mymath as m # 모듈 이름이 길면 별칭 지정하여 사용 가능 ->SQL같음
from mymath import  add # 모듈 안에 특정 함수만 사용 가능함.
from mymath import *



print(mymath.add(2,3))
print(mymath.circle_area(2))
print(m.add(3,4))
print(add(3,4))
print(circle_area(5))
