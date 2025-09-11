# 문자열 → 정수
a = int("10")
print(a, type(a))   # 10 <class 'int'>

# 문자열 → 실수
b = float("3.14")
print(b, type(b))   # 3.14 <class 'float'>

# 숫자 → 문자열
c = str(123)
print(c, type(c))   # "123" <class 'str'>
# ---------------------------------------
print(bool(0))      # False
print(bool(1))      # True
print(bool(""))     # False (빈 문자열)
print(bool("0"))    # True  (문자열 "0"은 내용이 있으므로 True)
print(bool([]))     # False (빈 리스트)
print(bool([1]))    # True

#-----------------------------------------
# 컬렉션 변환
data = [1, 2, 2, 3]

# list → set (중복 제거)
s = set(data)
print(s, type(s))   # {1,2,3}

# set → list
l = list(s)
print(l, type(l))   # [1,2,3]

# tuple 변환
t = tuple(data)
print(t, type(t))   # (1,2,2,3)
#-----------------------------------------
# dict 변환
d = {"a": 1, "b": 2, "c": 3}

# 키만 리스트로
# keys = list(d)
# print(keys)   # ['a', 'b', 'c']
#
# # 값만 리스트로
# values = list(d.values())
# print(values) # [1, 2, 3]
#
# # 키-값 쌍 튜플로
# items = list(d.items())
# print(items)  # [('a',1), ('b',2), ('c',3)]

print(list(d.keys()))
print(list(d.values()))
print(list(d.items()))
# -----------------------------------------
# 예제
# 사용자 입력(문자열) → 숫자 변환
year = int("2025")
month = int("9")
day = int("8")

date = f"{year:04d}-{month:02d}-{day:02d}"
print(date)   # 2025-09-08
