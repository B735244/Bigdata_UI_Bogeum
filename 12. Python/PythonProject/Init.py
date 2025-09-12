# 1. 주석
#
# # 2. 출력함수(생략)
# # 3. 입력함수
# name = input("이름을 입력하세요:")
# print("입력한 이름:", name)
#
# # 4. 숫자 입력
# age = int(input("나이를 입력하세요:"))
# print("내년 나이:",age+1)
#
# #5. 변수
# # 1) 변수 선언과 값 대입
# age = 39
# height = 1.75
# name = "Alice"
#
# #  변수 출력
# print(name)
# print(age)
# print(height)
#
# # 여러 변수 출력
# print("name:", name, "age:", age, "height:", height)
#
# # 문자열 포매팅 (f-string)
# print(f"[f-string] {name} - age={age}, height={height}")
#
# # 자료형 확인
# print(type(name))   # <class 'str'>
# print(type(age))    # <class 'int'>
# print(type(height)) # <class 'float'>
#
# # 변수 재할당
# age = 40
# print("새 나이:", age)
#
# # 변수 삭제
# del age
# # print(age)  # 오류 발생: age is not defined```
#
# ## 여러 변수 한 줄 대입·언패킹·스왑
#
#
# # 1) 여러 변수에 한 줄 대입
# x, y, z = 10, 20, 30
# print(x, y, z)
#
# # 같은 값 대입
# a = b = c = 100
# print(a, b, c)
#
# # 값 교환 (스왑)
# x, y = y, x
# print("스왑 후:", x, y)
#
# # 언패킹 (리스트/튜플 분해)
# numbers = [1, 2, 3]
# n1, n2, n3 = numbers
# print(n1, n2, n3)
#
# # 확장 언패킹 (*)
# first, *rest = [10, 20, 30, 40, 50]
# print(first)   # 10
# print(rest)    # [20, 30, 40, 50]
#
# # 언패킹 응용: 마지막 값 따로 받기
# *start, end = [100, 200, 300, 400]
# print(start, end)  # [100, 200, 300] 400```

# 예제
# 리스트 언패킹 예제
Numbers = [5,10,15,20,25]
first,second,*rest = Numbers
x,y =first,second
print("x:",x,"y:",y,"rest:",rest)
# -----------------------------------
# 리스트 교환, 연산
m=100
n=200
print("m=",m,"n=",n)
m,n=n,m
print("m=",m,"n=",n)
print("m+n:",m+n)


