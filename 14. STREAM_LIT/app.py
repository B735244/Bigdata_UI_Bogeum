import streamlit as st
from datetime import datetime, date
#--------------------
#페이지 설정
# --------------------
st.set_page_config(
    page_title="스트림릿 UI 가이드",
    page_icon="emogi",
    layout="wide",
    initial_sidebar_state="collapsed",
    menu_items={
        'Get Help' : 'https://docs.streamlit.io/',
        'Report a Bug' : 'https://github.com/streamlit',
        'About' : 'Streamlit 가이드 앱입니다@_@'
    }
)
# ----------------------
# 제목/text
# ----------------------
st.title("PAGE INIT TEST")
st.header("1단계: 텍스트 표시")
st.subheader("다양한 텍스트 스타일")

st.write("일반 텍스트를 표시합니다.")
st.markdown("**굵은 글씨**와 *기울임* 그리고 `코드` 형식도 가능함@_@")
st.caption("작은 캡션 텍스트입니다.")
st.code("print('코드블록예제')", language="python")

st.divider()
# ----------------------
# 입력 위젯
# ----------------------

col1, col2, = st.columns(2)
with col1:
    st.subheader('첫번째 컬럼')
    text_input = st.text_input("이름을 입력하세요", placeholder="손보금")
    text_area = st.text_area("메세지를 입력하세요", placeholder="여기에 입력")
    number_input = st.number_input("숫자를 입력하세요", min_value=0, max_value=100, value=50)
    #
    # st.write('text_input',text_input)
    if text_input:
        st.success(f"이름 :{text_input}")
    if text_area:
        st.info(f"메세지 :{text_area}")
    if number_input:
        st.warning(f"숫자 :{number_input}")    
st.divider()
with col2:
    st.subheader("선택 위젯")
    selectbox = st.selectbox("옵션을 선택하세요", ["옵션1","옵션2","옵션3"])
    multiselect=st.multiselect("여러 개 선택 가능",["A","B","C","D"])
    radio = st.radio("하나만 선택",["예", "아니오","모름"])
    st.write('selectbox',selectbox)
    st.write('multiselect',multiselect)
    st.write('radio',radio)


#-------------
# 입력위젯
#-------------
st.header("3단계: 날짜 및 시간 입력")

col1,col2,col3=st.columns(3)

with col1:
    date_input=st.date_input("날짜 선택", value=date.today())
    st.write(f"date_input: {date_input}")

with col2:
    time_input = st.time_input("시간 선택")
    st.write(f"time_input: {time_input}")

with col3:
    slider= st.slider("슬라이더",0, 100, 50)
    st.write(f"slider: {slider}")

st.divider()

#======================
# 입력 위젯3
#=====================

col1, col2 = st.columns(2)

with col1:
    checkbox1 = st.checkbox("동의합니다",value=True)
    checkbox2 = st.checkbox("뉴스레터 구독")
    checkbox3 = st.checkbox("마케팅 수신 동의")

with col2:
    toggle1=st.toggle("알림 활성화", value=True)
    toggle2=st.toggle("타크 모드")
    toggle3 = st.toggle("자동저장")


#===================
#버튼
#===========
st.header("4단계: 버튼")
col1,col2,col3,col4 =st.columns(4)

with col1:
    if st.button("일반 버튼", type="primary"):
        st.success("버튼이 클릭되었습니다.")

with col2:
    if st.button("보조 버튼", type="secondary"):
        st.info("보조 버튼 클릭")

with col3:
    if st.button("다운로드", data ="샘플 데이터", file_name="sample.txt"):
        st.success("다운로드 시잒!!!")

with temp=pd.DataFram({'이름:'["김범수","박효신",'박정현"],}
    '나이':[50,51,52],
    '주소' : ['서울,'부산','대구']
            } )
df_tmp.to_csv('//appdataSet/학생 점수,csv'rb') as f:
              st.downlosd_button(
                  label="CSV 다운로드"
                  data =finally
                  file_name ="학생딀의 점수"
                  "mint ="text/csv"
              )    

df_tbl = pd.DataFrame({
    '이름:'[],
    '나이:'[],
    '점수:'[],
    '등급:'[]
})
      
with st.sidebar:
    st.title('사이드바')