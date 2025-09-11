# 덧셈, 뺄셈, 곱셈, 나눗셈
a, b = 7, 2
print("a + b =", a + b)    # 9
print("a - b =", a - b)    # 5
print("a * b =", a * b)    # 14
print("a / b =", a / b)    # 3.5  (항상 실수)

# 몫, 나머지, 거듭제곱
print("a // b =", a // b)  # 3
print("a % b  =", a % b)   # 1
print("2 ** 3 =", 2 ** 3)  # 8
# ------------------------------------------
# 비교연산자
x, y = 5, 3
print("x == y :", x == y)   # False
print("x != y :", x != y)   # True
print("x >  y :", x > y)    # True
print("x <  y :", x < y)    # False
print("x >= y :", x >= y)   # True
print("x <= y :", x <= y)   # False

# 체이닝(파이썬만의 문법)
n = 4
print(3 < n < 10)    # True (3 < n and n < 10)

# ------------------------------------------
# 논리연산자
a, b = True, False
print("a and b :", a and b)    # False
print("a or  b :", a or b)     # True
print("not a   :", not a)      # False

# 단락 평가(short-circuit) 예시
def f():
    print("f() called")
    return True

print(False and f())  # False (f()는 호출되지 않음)
print(True or f())    # True  (f()는 호출되지 않음)
# ------------------------------------------
# 대입, 복합연산자
x = 10      # 대입
x += 5      # 15
x -= 3      # 12
x *= 2      # 24
x /= 4      # 6.0 (실수 주의)
x //= 2     # 3
x %= 2      # 1
x **= 5     # 1 ** 5 = 1
print("x =", x)

# 문자열/리스트에도 사용 가능
s = "ha"
s *= 3
print(s)    # "hahaha"

arr = [1]
arr *= 3
print(arr)  # [1, 1, 1]
# ----------------------------------------
# 비트연산자
a, b = 6, 3                 # a=0b110, b=0b011
print("a & b =", a & b)     # 2  (0b010)
print("a | b =", a | b)     # 7  (0b111)
print("a ^ b =", a ^ b)     # 5  (0b101)

# 비트 NOT: ~n = -(n+1)
print("~6 =", ~6)           # -7

# 시프트
print("3 << 1 =", 3 << 1)   # 6
print("6 >> 1 =", 6 >> 1)   # 3

# 2진수로 보기 좋게 출력
n = 13
print("n      :", n, bin(n))         # 13 0b1101
print("n<<2   :", n << 2, bin(n<<2)) # 52 0b110100
print("n>>1   :", n >> 1, bin(n>>1)) # 6  0b110

# ---------------------------------------------
# 멤버십/식별 연산자
# 멤버십: in / not in
text = "apple"
print("'a' in text     :", "a" in text)      # True
print("'x' not in text :", "x" not in text)  # True

nums = [1, 2, 3]
print("2 in nums      :", 2 in nums)         # True
print("4 not in nums  :", 4 not in nums)     # True

# 식별: is / is not  (객체 동일성)
a = [1, 2, 3]
b = [1, 2, 3]
c = a

print("a == b  :", a == b)    # 값(내용)은 같다 -> True
print("a is b  :", a is b)    # 객체(참조)는 다르다 -> False
print("a is c  :", a is c)    # 같은 객체 참조 -> True

# 작은 정수/짧은 문자열 캐싱으로 is가 True처럼 보일 수 있으니 ==와 구분할 것
s1 = "py"
s2 = "py"
print("s1 == s2:", s1 == s2)  # True (값 비교)
print("s1 is s2:", s1 is s2)  # (환경별 최적화 영향) 동일성 보장은 아님





