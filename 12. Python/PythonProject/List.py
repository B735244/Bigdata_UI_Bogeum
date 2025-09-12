# ------
fruits = ["apple", "banana", "cherry"]
print(fruits[0])   # apple
print(fruits[1])   # banana

# 빈 리스트
a = []
b = list()

# 초기 값 포함
nums = [1, 2, 3, 4, 5]

# 다른 자료형도 혼합 가능
mixed = [1, "hi", 3.14, True]
# 슬라이싱
# nums = [10, 20, 30, 40, 50]

print(nums[0])     # 10
print(nums[-1])    # 50 (뒤에서 첫 번째)
print(nums[1:4])   # [20, 30, 40]
print(nums[:3])    # [10, 20, 30]
print(nums[::2])   # [10, 30, 50] (2칸씩 건너뛰기)

# 리스트 Method
# fruits = ["apple", "banana", "cherry"]

fruits.append("orange")   # 마지막에 추가
fruits.insert(1, "grape") # 인덱스 1에 삽입
fruits.remove("banana")   # 특정 값 제거
popped = fruits.pop()     # 마지막 요소 꺼내기
print("popped:", popped)

fruits.sort()             # 오름차순 정렬
fruits.reverse()          # 반대로 뒤집기
print(fruits)

count = fruits.count("apple")   # 개수 세기
index = fruits.index("cherry")  # 위치 찾기

# 리스트와 반복문
nums = [1, 2, 3, 4, 5]

# for문
for n in nums:
    print(n)

# enumerate 사용
for i, n in enumerate(nums):
    print(i, n)

# list 컴프리헨션
# 1~5 제곱수
squares = [x**2 for x in range(1, 6)]
print(squares)  # [1, 4, 9, 16, 25]

# 짝수만 선택
evens = [x for x in range(10) if x % 2 == 0]
print(evens)  # [0, 2, 4, 6, 8]

#2차원 리스트
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print(matrix[0][1])  # 2
print(matrix[2][2])  # 9

# 중첩 반복문으로 출력
for row in matrix:
    for val in row:
        print(val, end=" ")
    print()

# 리스트 복사 주의
a = [1, 2, 3]
b = a          # 얕은 복사 (같은 객체)
c = a[:]       # 슬라이싱으로 복사 (새로운 객체)
d = list(a)    # list()로 복사

a[0] = 100
print("a:", a)  # [100, 2, 3]
print("b:", b)  # [100, 2, 3] → 같은 객체라서 같이 변경됨
print("c:", c)  # [1, 2, 3]
print("d:", d)  # [1, 2, 3]

# 리스트에 있는 문자열과 인덱스값 출력
listbox = ['길벗','시나공','빅분기', '분석']
for index, item in enumerate(listbox):
    print(index, item)

# 리스트[10, 20, 30, 40, 50]의 첫번째 요소와 마지막 요소를 출력하세요
list1 = [10,20,30,40,50]

print(list1[0])
print(list1[-1])

# 리스트 [1, 2, 3]에 4와 5 추가

list3 = [1,2,3]
list3.append(4)
list3.append(5)
print(list3)

# 리스트 [3, 6, 9, 12, 15]에서 인덱스 1~3 구간을 슬라이싱하여 출력하시오.
list4= [3,6,9,12,15]
print(list4[0:3])

# 리스트 [5, 2, 9, 1, 7]을 정렬하여 출력하고, 다시 반대로 뒤집어 출력하시오.
list5 = [5,2,9,1,7]
list5.sort()
print(list5)
list5.reverse()
print(
    list5
)

# 1부터 5까지의 제곱수를 리스트 컴프리헨션으로 생성하고 출력하시오.
# 출력: [1, 4, 9, 16, 25]
squares = [x**2 for x in range(1, 6)]
print(squares)  # [1, 4, 9, 16, 25]




