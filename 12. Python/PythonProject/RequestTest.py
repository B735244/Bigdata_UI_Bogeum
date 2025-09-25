import requests

res = requests.get("https://www.naver.com/")
print(res.status_code)
print(res.headers)
print(res.headers.get('Content-Type'))
