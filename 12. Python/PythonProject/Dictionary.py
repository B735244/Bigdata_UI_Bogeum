# 딕셔너리
person = {"name": "Alice", "age": 25, "city": "Seoul"}
print(person["name"])  # Alice

# 딕셔너리 생성 방법
# 기본 생성
d1 = {"a": 1, "b": 2}

# dict() 함수 활용
d2 = dict(a=1, b=2)

# 리스트/튜플 쌍을 변환
d3 = dict([("a", 1), ("b", 2)])

print(d1, d2, d3)

# 딕셔너리 메서드
person = {"name": "Alice", "age": 25, "city": "Seoul"}

# 키, 값, 쌍
print(person.keys())     # dict_keys(['name', 'age', 'city'])
print(person.values())   # dict_values(['Alice', 25, 'Seoul'])
print(person.items())    # dict_items([('name','Alice'),('age',25),('city','Seoul')])

# get() : 키 없을 때 None 반환
print(person.get("age"))       # 25
print(person.get("country"))   # None
print(person.get("country", "없음"))  # 없음

# pop() : 특정 키 제거 + 값 반환
age = person.pop("age")
print(age, person)

# update() : 다른 딕셔너리 병합
person.update({"job": "teacher"})
print(person)

# 반복문과 딕셔너리
scores = {"kim": 90, "lee": 85, "park": 95}

# 키만 반복
for k in scores:
    print(k)

# 값만 반복
for v in scores.values():
    print(v)

# 키와 값 동시 반복
for k, v in scores.items():
    print(k, v)

# 딕셔너리 컴프리헨션
# 1~5까지 제곱 딕셔너리 만들기
squares = {x: x**2 for x in range(1, 6)}
print(squares)   # {1:1, 2:4, 3:9, 4:16, 5:25}

# 조건 추가
evens = {x: x**2 for x in range(1, 6) if x % 2 == 0}
print(evens)     # {2:4, 4:16}

# 중첩 딕셔너리
students = {
    "kim": {"age": 20, "major": "CS"},
    "lee": {"age": 22, "major": "Math"}
}

print(students["kim"]["major"])  # CS

# 딕셔너리 반복문
person_info = {
    'name': '사랑',
    'age': 20,
    'city': '부산',
    'hobbies': ['연애', '수영', '코딩']
}
for k, v in zip(person_info.keys(), person_info.values()):
    print(k, v)


# 딕셔너리 {"name":"kim", "age":20, "city":"Seoul"}에서
# - name과 city를 출력하시오.

dict1 = {"name": "Kim", "age": 20, "city": "Seoul"}
print("name: "+ dict1["name"])
print("city: "+dict1["city"])


# 빈 딕셔너리를 만든 후,
# - "math"=90, "eng"=85 를 추가하고 전체를 출력하시오.

dict2 = {}
dict2["math"]=90
dict2["eng"]=85
print(dict2)

# 딕셔너리 {"a":1, "b":2, "c":3}에서- 키만 출력하고- 값만 출력하고 - 키와 값을 함께 출력하시오.
dict3 ={"a": 1, "b": 2, "c": 3}
print(dict3.keys())
print(dict3.values())
print(dict3.items())

# 딕셔너리 {"apple":1000, "banana":2000, "cherry":3000}에서
# - "banana"의 값을 2500으로 수정하고
# - "orange"=1500을 추가한 뒤
# 전체를 출력하시오.

dict4 = {"a": 1000, "b": 2000, "c": 3000}
dict4["b"] = 2500
dict4["orange"] = 1500
print(dict4)

# 딕셔너리 컴프리헨션으로
# 1~5까지 숫자를 키로 하고, 제곱을 값으로 하는 딕셔너리를 생성하시오.
squares = {x: x**2 for x in range(1, 6)}
print(squares)   # {1:1, 2:4, 3:9, 4:16, 5:25}
squares_add = squares.values()
print(squares_add)
sum1 = sum(squares_add)
print(sum1)
