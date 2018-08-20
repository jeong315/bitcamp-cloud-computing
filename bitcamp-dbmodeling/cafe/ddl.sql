-- 수강 신청
DROP TABLE IF EXISTS TABLE RESTRICT;

-- 학생
DROP TABLE IF EXISTS TABLE2 RESTRICT;

-- 강사
DROP TABLE IF EXISTS TABLE3 RESTRICT;

-- 강의실
DROP TABLE IF EXISTS TABLE4 RESTRICT;

-- 매니저
DROP TABLE IF EXISTS TABLE5 RESTRICT;

-- 교육 과정
DROP TABLE IF EXISTS TABLE6 RESTRICT;

-- 프로젝트
DROP TABLE IF EXISTS TABLE7 RESTRICT;

-- 과목
DROP TABLE IF EXISTS TABLE8 RESTRICT;

-- 수강생
DROP TABLE IF EXISTS TABLE9 RESTRICT;

-- 고객
DROP TABLE IF EXISTS C1_CST RESTRICT;

-- 직원
DROP TABLE IF EXISTS C1_STFF RESTRICT;

-- 공급처
DROP TABLE IF EXISTS C1_SUPP RESTRICT;

-- 음료
DROP TABLE IF EXISTS C1_BVRG RESTRICT;

-- 지점
DROP TABLE IF EXISTS C1_BRCH RESTRICT;

-- 주문
DROP TABLE IF EXISTS C1_ORD RESTRICT;

-- 배달
DROP TABLE IF EXISTS C1_DEL RESTRICT;

-- 지점장
DROP TABLE IF EXISTS C1_MNG RESTRICT;

-- MD 제품
DROP TABLE IF EXISTS C1_MD RESTRICT;

-- 푸드
DROP TABLE IF EXISTS C1_FOOD RESTRICT;

-- 재고관리
DROP TABLE IF EXISTS C1_STCK RESTRICT;

-- 멤버십
DROP TABLE IF EXISTS C1_CST_MEMB RESTRICT;

-- 직원관리
DROP TABLE IF EXISTS C1_STFF_MNG RESTRICT;

-- 사은품
DROP TABLE IF EXISTS C1_GIFT RESTRICT;

-- 주소
DROP TABLE IF EXISTS C1_ADDR RESTRICT;

-- 개인정보
DROP TABLE IF EXISTS C1_PROF RESTRICT;

-- 상품정보
DROP TABLE IF EXISTS C1_GDS RESTRICT;

-- 계좌정보
DROP TABLE IF EXISTS C1_BANK RESTRICT;

-- 계약기간
DROP TABLE IF EXISTS C1_TERM RESTRICT;

-- 고객설문조사
DROP TABLE IF EXISTS C1_CST_SBY RESTRICT;

-- 결제정보
DROP TABLE IF EXISTS C1_PAY RESTRICT;

-- 수강 신청
CREATE TABLE TABLE (
	COL  <데이터 타입 없음> NULL COMMENT '학생', -- 학생
	COL2 <데이터 타입 없음> NULL COMMENT '교육과정', -- 교육과정
	COL3 <데이터 타입 없음> NULL COMMENT '신청일', -- 신청일
	COL4 <데이터 타입 없음> NULL COMMENT '신청 상태', -- 신청 상태
	COL5 <데이터 타입 없음> NULL COMMENT '새 컬럼' -- 새 컬럼
)
COMMENT '수강 신청';

-- 학생
CREATE TABLE TABLE2 (
	COL   <데이터 타입 없음> NULL COMMENT '이름', -- 이름
	COL2  <데이터 타입 없음> NULL COMMENT '이메일', -- 이메일
	COL11 <데이터 타입 없음> NULL COMMENT '암호', -- 암호
	COL3  <데이터 타입 없음> NULL COMMENT '전화', -- 전화
	COL4  <데이터 타입 없음> NULL COMMENT '재직여부', -- 재직여부
	COL5  <데이터 타입 없음> NULL COMMENT '우편번호', -- 우편번호
	COL6  <데이터 타입 없음> NULL COMMENT '기본주소', -- 기본주소
	COL7  <데이터 타입 없음> NULL COMMENT '상세주소', -- 상세주소
	COL8  <데이터 타입 없음> NULL COMMENT '최종학력', -- 최종학력
	COL9  <데이터 타입 없음> NULL COMMENT '전공', -- 전공
	COL10 <데이터 타입 없음> NULL COMMENT '사진' -- 사진
)
COMMENT '학생';

-- 강사
CREATE TABLE TABLE3 (
	COL   <데이터 타입 없음> NULL COMMENT '이름', -- 이름
	COL2  <데이터 타입 없음> NULL COMMENT '이메일', -- 이메일
	COL11 <데이터 타입 없음> NULL COMMENT '암호', -- 암호
	COL3  <데이터 타입 없음> NULL COMMENT '전화', -- 전화
	COL4  <데이터 타입 없음> NULL COMMENT '강사료', -- 강사료
	COL5  <데이터 타입 없음> NULL COMMENT '과목1', -- 과목1
	COL6  <데이터 타입 없음> NULL COMMENT '과목2', -- 과목2
	COL7  <데이터 타입 없음> NULL COMMENT '과목3', -- 과목3
	COL8  <데이터 타입 없음> NULL COMMENT '과목4', -- 과목4
	COL9  <데이터 타입 없음> NULL COMMENT '과목5', -- 과목5
	COL10 <데이터 타입 없음> NULL COMMENT '사진' -- 사진
)
COMMENT '강사';

-- 강의실
CREATE TABLE TABLE4 (
	COL3 <데이터 타입 없음> NULL COMMENT '센터', -- 센터
	COL  <데이터 타입 없음> NULL COMMENT '강의실명', -- 강의실명
	COL2 <데이터 타입 없음> NULL COMMENT '최대수용인원' -- 최대수용인원
)
COMMENT '강의실';

-- 매니저
CREATE TABLE TABLE5 (
	COL  <데이터 타입 없음> NULL COMMENT '이름', -- 이름
	COL2 <데이터 타입 없음> NULL COMMENT '이메일', -- 이메일
	COL6 <데이터 타입 없음> NULL COMMENT '암호', -- 암호
	COL3 <데이터 타입 없음> NULL COMMENT '전화', -- 전화
	COL4 <데이터 타입 없음> NULL COMMENT '직위', -- 직위
	COL5 <데이터 타입 없음> NULL COMMENT '사진' -- 사진
)
COMMENT '매니저';

-- 교육 과정
CREATE TABLE TABLE6 (
	COL  <데이터 타입 없음> NULL COMMENT '과정명', -- 과정명
	COL2 <데이터 타입 없음> NULL COMMENT '시작일', -- 시작일
	COL3 <데이터 타입 없음> NULL COMMENT '종료일', -- 종료일
	COL4 <데이터 타입 없음> NULL COMMENT '교육시간', -- 교육시간
	COL5 <데이터 타입 없음> NULL COMMENT '일교육시간', -- 일교육시간
	COL6 <데이터 타입 없음> NULL COMMENT '과정설명' -- 과정설명
)
COMMENT '교육 과정';

-- 프로젝트
CREATE TABLE TABLE7 (
	COL   <데이터 타입 없음> NULL COMMENT '프로젝트명', -- 프로젝트명
	COL2  <데이터 타입 없음> NULL COMMENT '내용', -- 내용
	COL3  <데이터 타입 없음> NULL COMMENT '시작일', -- 시작일
	COL4  <데이터 타입 없음> NULL COMMENT '종료일', -- 종료일
	COL5  <데이터 타입 없음> NULL COMMENT '팀원1', -- 팀원1
	COL6  <데이터 타입 없음> NULL COMMENT '팀원2', -- 팀원2
	COL7  <데이터 타입 없음> NULL COMMENT '팀원3', -- 팀원3
	COL8  <데이터 타입 없음> NULL COMMENT '팀원4', -- 팀원4
	COL9  <데이터 타입 없음> NULL COMMENT '팀원5', -- 팀원5
	COL10 <데이터 타입 없음> NULL COMMENT '팀원6', -- 팀원6
	COL11 <데이터 타입 없음> NULL COMMENT '팀원7' -- 팀원7
)
COMMENT '프로젝트';

-- 과목
CREATE TABLE TABLE8 (
	COL  <데이터 타입 없음> NULL COMMENT '과목명', -- 과목명
	COL2 <데이터 타입 없음> NULL COMMENT '과목설명', -- 과목설명
	COL3 <데이터 타입 없음> NULL COMMENT '강사1', -- 강사1
	COL4 <데이터 타입 없음> NULL COMMENT '강사2' -- 강사2
)
COMMENT '과목';

-- 수강생
CREATE TABLE TABLE9 (
	COL  <데이터 타입 없음> NULL COMMENT '이름', -- 이름
	COL2 <데이터 타입 없음> NULL COMMENT '이메일', -- 이메일
	COL3 <데이터 타입 없음> NULL COMMENT '전화', -- 전화
	COL4 <데이터 타입 없음> NULL COMMENT '최종학력', -- 최종학력
	COL5 <데이터 타입 없음> NULL COMMENT '전공', -- 전공
	COL6 <데이터 타입 없음> NULL COMMENT '은행명', -- 은행명
	COL7 <데이터 타입 없음> NULL COMMENT '계좌번호' -- 계좌번호
)
COMMENT '수강생';

-- 고객
CREATE TABLE C1_CST (
	CSTNO    INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
	CST_MEMB INTEGER     NOT NULL COMMENT '멤버십', -- 멤버십
	CST_NICK VARCHAR(50) NULL     COMMENT '닉네임', -- 닉네임
	BRCHNO   INTEGER     NOT NULL COMMENT '지점번호', -- 지점번호
	PROFNO   INTEGER     NOT NULL COMMENT '개인정보번호' -- 개인정보번호
)
COMMENT '고객';

-- 고객
ALTER TABLE C1_CST
	ADD CONSTRAINT PK_C1_CST -- 고객 기본키
		PRIMARY KEY (
			CSTNO -- 고객번호
		);

-- 고객 유니크 인덱스
CREATE UNIQUE INDEX UIX_C1_CST
	ON C1_CST ( -- 고객
	);

-- 직원
CREATE TABLE C1_STFF (
	STFFNO   INTEGER NOT NULL COMMENT '직원번호', -- 직원번호
	STFF_CRR TEXT    NULL     COMMENT '경력', -- 경력
	BRCHNO   INTEGER NOT NULL COMMENT '지점번호', -- 지점번호
	ADDRNO   INTEGER NOT NULL COMMENT '주소번호', -- 주소번호
	PROFNO   INTEGER NOT NULL COMMENT '개인정보번호', -- 개인정보번호
	BANKNO   INTEGER NOT NULL COMMENT '계좌정보번호' -- 계좌정보번호
)
COMMENT '직원';

-- 직원
ALTER TABLE C1_STFF
	ADD CONSTRAINT PK_C1_STFF -- 직원 기본키
		PRIMARY KEY (
			STFFNO -- 직원번호
		);

-- 직원 유니크 인덱스
CREATE UNIQUE INDEX UIX_C1_STFF
	ON C1_STFF ( -- 직원
	);

-- 공급처
CREATE TABLE C1_SUPP (
	SUPPNO INTEGER     NOT NULL COMMENT '공급처번호', -- 공급처번호
	SUPPNM VARCHAR(50) NOT NULL COMMENT '공급처명', -- 공급처명
	CTGR   VARCHAR(50) NOT NULL COMMENT '종류', -- 종류
	LOCT   VARCHAR(50) NOT NULL COMMENT '위치', -- 위치
	BRCHNO INTEGER     NOT NULL COMMENT '지점번호', -- 지점번호
	TRNO   INTEGER     NOT NULL COMMENT '계약기간번호' -- 계약기간번호
)
COMMENT '공급처';

-- 공급처
ALTER TABLE C1_SUPP
	ADD CONSTRAINT PK_C1_SUPP -- 공급처 기본키
		PRIMARY KEY (
			SUPPNO -- 공급처번호
		);

-- 음료
CREATE TABLE C1_BVRG (
	BVRGNO   INTEGER NOT NULL COMMENT '음료번호', -- 음료번호
	BVRG_CF  CHAR(1) NOT NULL COMMENT '카페인', -- 카페인
	BVRG_SZ  INTEGER NOT NULL COMMENT '사이즈', -- 사이즈
	BVRG_TO  CHAR(1) NOT NULL COMMENT '포장', -- 포장
	BVRG_TMP CHAR(1) NOT NULL COMMENT '온도', -- 온도
	GDSNO    INTEGER NOT NULL COMMENT '상품정보번호' -- 상품정보번호
)
COMMENT '음료';

-- 음료
ALTER TABLE C1_BVRG
	ADD CONSTRAINT PK_C1_BVRG -- 음료 기본키
		PRIMARY KEY (
			BVRGNO -- 음료번호
		);

-- 지점
CREATE TABLE C1_BRCH (
	BRCHNO INTEGER     NOT NULL COMMENT '지점번호', -- 지점번호
	BRCHNM VARCHAR(50) NOT NULL COMMENT '지점명', -- 지점명
	CPCT   INTEGER     NOT NULL COMMENT '수용인원', -- 수용인원
	MNGNO  INTEGER     NOT NULL COMMENT '지점장번호', -- 지점장번호
	ORDNO  INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	ADDRNO INTEGER     NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '지점';

-- 지점
ALTER TABLE C1_BRCH
	ADD CONSTRAINT PK_C1_BRCH -- 지점 기본키
		PRIMARY KEY (
			BRCHNO -- 지점번호
		);

-- 지점 유니크 인덱스
CREATE UNIQUE INDEX UIX_C1_BRCH
	ON C1_BRCH ( -- 지점
	);

-- 지점 인덱스
CREATE INDEX IX_C1_BRCH
	ON C1_BRCH( -- 지점
		BRCHNM ASC -- 지점명
	);

-- 주문
CREATE TABLE C1_ORD (
	ORDNO    INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	ORD_NICK VARCHAR(50) NULL     COMMENT '닉네임', -- 닉네임
	ORD_STAT INTEGER     NOT NULL COMMENT '상태', -- 상태
	ORD_TIME DATETIME    NOT NULL COMMENT '주문시간', -- 주문시간
	MDNO     INTEGER     NOT NULL COMMENT 'MD제품번호', -- MD제품번호
	FOODNO   INTEGER     NOT NULL COMMENT '푸드번호', -- 푸드번호
	GIFTNO   INTEGER     NOT NULL COMMENT '사은품번호', -- 사은품번호
	BVRGNO   INTEGER     NOT NULL COMMENT '음료번호' -- 음료번호
)
COMMENT '주문';

-- 주문
ALTER TABLE C1_ORD
	ADD CONSTRAINT PK_C1_ORD -- 주문 기본키
		PRIMARY KEY (
			ORDNO -- 주문번호
		);

-- 배달
CREATE TABLE C1_DEL (
	DELNO   INTEGER     NOT NULL COMMENT '배달번호', -- 배달번호
	DEL_NM  VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	DEL_TEL VARCHAR(30) NOT NULL COMMENT '전화번호', -- 전화번호
	DEL_SAY TEXT        NULL     COMMENT '한마디', -- 한마디
	ORDNO   INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	ADDRNO  INTEGER     NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '배달';

-- 배달
ALTER TABLE C1_DEL
	ADD CONSTRAINT PK_C1_DEL -- 배달 기본키
		PRIMARY KEY (
			DELNO -- 배달번호
		);

-- 지점장
CREATE TABLE C1_MNG (
	MNGNO    INTEGER     NOT NULL COMMENT '지점장번호', -- 지점장번호
	MNG_CRR  TEXT        NULL     COMMENT '경력', -- 경력
	MNG_BRCH VARCHAR(50) NOT NULL COMMENT '담당지점', -- 담당지점
	ADDRNO   INTEGER     NOT NULL COMMENT '주소번호', -- 주소번호
	PROFNO   INTEGER     NOT NULL COMMENT '개인정보번호', -- 개인정보번호
	BANKNO   INTEGER     NOT NULL COMMENT '계좌정보번호' -- 계좌정보번호
)
COMMENT '지점장';

-- 지점장
ALTER TABLE C1_MNG
	ADD CONSTRAINT PK_C1_MNG -- 지점장 기본키
		PRIMARY KEY (
			MNGNO -- 지점장번호
		);

-- 지점장 유니크 인덱스
CREATE UNIQUE INDEX UIX_C1_MNG
	ON C1_MNG ( -- 지점장
	);

-- MD 제품
CREATE TABLE C1_MD (
	MDNO  INTEGER NOT NULL COMMENT 'MD제품번호', -- MD제품번호
	GDSNO INTEGER NOT NULL COMMENT '상품정보번호', -- 상품정보번호
	TRNO  INTEGER NOT NULL COMMENT '계약기간번호' -- 계약기간번호
)
COMMENT 'MD 제품';

-- MD 제품
ALTER TABLE C1_MD
	ADD CONSTRAINT PK_C1_MD -- MD 제품 기본키
		PRIMARY KEY (
			MDNO -- MD제품번호
		);

-- 푸드
CREATE TABLE C1_FOOD (
	FOODNO   INTEGER NOT NULL COMMENT '푸드번호', -- 푸드번호
	FOOD_TO  CHAR(1) NOT NULL COMMENT '포장', -- 포장
	FOOD_TMP CHAR(1) NOT NULL COMMENT '온도', -- 온도
	GDSNO    INTEGER NOT NULL COMMENT '상품정보번호' -- 상품정보번호
)
COMMENT '푸드';

-- 푸드
ALTER TABLE C1_FOOD
	ADD CONSTRAINT PK_C1_FOOD -- 푸드 기본키
		PRIMARY KEY (
			FOODNO -- 푸드번호
		);

-- 재고관리
CREATE TABLE C1_STCK (
	STCKNO   INTEGER     NOT NULL COMMENT '재고번호', -- 재고번호
	STCK_NM  VARCHAR(50) NOT NULL COMMENT '제품명', -- 제품명
	STCK_CNT INTEGER     NOT NULL COMMENT '수량', -- 수량
	STCK_EDT DATE        NOT NULL COMMENT '유통기한', -- 유통기한
	BRCHNO   INTEGER     NOT NULL COMMENT '지점번호' -- 지점번호
)
COMMENT '재고관리';

-- 재고관리
ALTER TABLE C1_STCK
	ADD CONSTRAINT PK_C1_STCK -- 재고관리 기본키
		PRIMARY KEY (
			STCKNO -- 재고번호
		);

-- 멤버십
CREATE TABLE C1_CST_MEMB (
	CUNO    INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
	GRD     INTEGER     NOT NULL COMMENT '등급', -- 등급
	STP     INTEGER     NOT NULL COMMENT '도장개수', -- 도장개수
	BRCH    VARCHAR(50) NOT NULL COMMENT '담당지점', -- 담당지점
	BRCH_LK VARCHAR(50) NULL     COMMENT '자주찾는지점', -- 자주찾는지점
	TRNO    INTEGER     NOT NULL COMMENT '계약기간번호' -- 계약기간번호
)
COMMENT '멤버십';

-- 멤버십
ALTER TABLE C1_CST_MEMB
	ADD CONSTRAINT PK_C1_CST_MEMB -- 멤버십 기본키
		PRIMARY KEY (
			CUNO -- 고객번호
		);

-- 직원관리
CREATE TABLE C1_STFF_MNG (
	STFFNO   INTEGER NOT NULL COMMENT '직원번호', -- 직원번호
	STFF_TS  INTEGER NOT NULL COMMENT '평가', -- 평가
	STFF_SLY INTEGER NOT NULL COMMENT '월급' -- 월급
)
COMMENT '직원관리';

-- 직원관리
ALTER TABLE C1_STFF_MNG
	ADD CONSTRAINT PK_C1_STFF_MNG -- 직원관리 기본키
		PRIMARY KEY (
			STFFNO -- 직원번호
		);

-- 사은품
CREATE TABLE C1_GIFT (
	GIFTNO   INTEGER     NOT NULL COMMENT '사은품번호', -- 사은품번호
	GIFT_NM  VARCHAR(50) NOT NULL COMMENT '사은품명', -- 사은품명
	GIFT_CNT INTEGER     NOT NULL COMMENT '수량', -- 수량
	TRNO     INTEGER     NOT NULL COMMENT '계약기간번호' -- 계약기간번호
)
COMMENT '사은품';

-- 사은품
ALTER TABLE C1_GIFT
	ADD CONSTRAINT PK_C1_GIFT -- 사은품 기본키
		PRIMARY KEY (
			GIFTNO -- 사은품번호
		);

-- 주소
CREATE TABLE C1_ADDR (
	ADDRNO   INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
	ADDR_ZC  VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
	ADDR_BSC VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
	ADDR_DTL VARCHAR(255) NOT NULL COMMENT '상세주소' -- 상세주소
)
COMMENT '주소';

-- 주소
ALTER TABLE C1_ADDR
	ADD CONSTRAINT PK_C1_ADDR -- 주소 기본키
		PRIMARY KEY (
			ADDRNO -- 주소번호
		);

-- 개인정보
CREATE TABLE C1_PROF (
	PROFNO   INTEGER     NOT NULL COMMENT '개인정보번호', -- 개인정보번호
	PROF_TEL VARCHAR(30) NOT NULL COMMENT '전화', -- 전화
	PROF_NM  VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	PROF_EM  VARCHAR(40) NOT NULL COMMENT '이메일' -- 이메일
)
COMMENT '개인정보';

-- 개인정보
ALTER TABLE C1_PROF
	ADD CONSTRAINT PK_C1_PROF -- 개인정보 기본키
		PRIMARY KEY (
			PROFNO -- 개인정보번호
		);

-- 개인정보 인덱스
CREATE INDEX IX_C1_PROF
	ON C1_PROF( -- 개인정보
		PROF_NM ASC -- 이름
	);

-- 상품정보
CREATE TABLE C1_GDS (
	GDSNO   INTEGER     NOT NULL COMMENT '상품정보번호', -- 상품정보번호
	GDS_NM  VARCHAR(50) NOT NULL COMMENT '제품명', -- 제품명
	GDS_CNT INTEGER     NOT NULL COMMENT '수량', -- 수량
	GDS_PRI INTEGER     NOT NULL COMMENT '가격' -- 가격
)
COMMENT '상품정보';

-- 상품정보
ALTER TABLE C1_GDS
	ADD CONSTRAINT PK_C1_GDS -- 상품정보 기본키
		PRIMARY KEY (
			GDSNO -- 상품정보번호
		);

-- 상품정보 인덱스
CREATE INDEX IX_C1_GDS
	ON C1_GDS( -- 상품정보
		GDS_NM ASC -- 제품명
	);

-- 계좌정보
CREATE TABLE C1_BANK (
	BANKNO  INTEGER     NOT NULL COMMENT '계좌정보번호', -- 계좌정보번호
	BANK_NM VARCHAR(50) NOT NULL COMMENT '은행명', -- 은행명
	BANK_AC INTEGER     NOT NULL COMMENT '계좌번호' -- 계좌번호
)
COMMENT '계좌정보';

-- 계좌정보
ALTER TABLE C1_BANK
	ADD CONSTRAINT PK_C1_BANK -- 계좌정보 기본키
		PRIMARY KEY (
			BANKNO -- 계좌정보번호
		);

-- 계약기간
CREATE TABLE C1_TERM (
	TRNO INTEGER NOT NULL COMMENT '계약기간번호', -- 계약기간번호
	SDT  DATE    NOT NULL COMMENT '시작일', -- 시작일
	EDT  DATE    NOT NULL COMMENT '종료일' -- 종료일
)
COMMENT '계약기간';

-- 계약기간
ALTER TABLE C1_TERM
	ADD CONSTRAINT PK_C1_TERM -- 계약기간 기본키
		PRIMARY KEY (
			TRNO -- 계약기간번호
		);

-- 고객설문조사
CREATE TABLE C1_CST_SBY (
	SBYNO   INTEGER NOT NULL COMMENT '고객설문조사번호', -- 고객설문조사번호
	SBY_TS  INTEGER NOT NULL COMMENT '총점', -- 총점
	SBY_SAY TEXT    NULL     COMMENT '자유한마디', -- 자유한마디
	CSTNO   INTEGER NOT NULL COMMENT '고객번호', -- 고객번호
	STFFNO  INTEGER NOT NULL COMMENT '직원번호' -- 직원번호
)
COMMENT '고객설문조사';

-- 고객설문조사
ALTER TABLE C1_CST_SBY
	ADD CONSTRAINT PK_C1_CST_SBY -- 고객설문조사 기본키
		PRIMARY KEY (
			SBYNO -- 고객설문조사번호
		);

-- 결제정보
CREATE TABLE C1_PAY (
	PAYNO     INTEGER NOT NULL COMMENT '결제정보번호', -- 결제정보번호
	PAY_HT    CHAR(1) NOT NULL COMMENT '결제방법', -- 결제방법
	PAY_AMT   INTEGER NOT NULL COMMENT '총결제액', -- 총결제액
	PAY_STMP  INTEGER NOT NULL COMMENT '결제도장개수', -- 결제도장개수
	PAY_TSTMP INTEGER NOT NULL COMMENT '총도장개수', -- 총도장개수
	ORDNO     INTEGER NOT NULL COMMENT '주문번호' -- 주문번호
)
COMMENT '결제정보';

-- 결제정보
ALTER TABLE C1_PAY
	ADD CONSTRAINT PK_C1_PAY -- 결제정보 기본키
		PRIMARY KEY (
			PAYNO -- 결제정보번호
		);

-- 고객
ALTER TABLE C1_CST
	ADD CONSTRAINT FK_C1_BRCH_TO_C1_CST -- 지점 -> 고객
		FOREIGN KEY (
			BRCHNO -- 지점번호
		)
		REFERENCES C1_BRCH ( -- 지점
			BRCHNO -- 지점번호
		);

-- 고객
ALTER TABLE C1_CST
	ADD CONSTRAINT FK_C1_PROF_TO_C1_CST -- 개인정보 -> 고객
		FOREIGN KEY (
			PROFNO -- 개인정보번호
		)
		REFERENCES C1_PROF ( -- 개인정보
			PROFNO -- 개인정보번호
		);

-- 직원
ALTER TABLE C1_STFF
	ADD CONSTRAINT FK_C1_BRCH_TO_C1_STFF -- 지점 -> 직원
		FOREIGN KEY (
			BRCHNO -- 지점번호
		)
		REFERENCES C1_BRCH ( -- 지점
			BRCHNO -- 지점번호
		);

-- 직원
ALTER TABLE C1_STFF
	ADD CONSTRAINT FK_C1_ADDR_TO_C1_STFF -- 주소 -> 직원
		FOREIGN KEY (
			ADDRNO -- 주소번호
		)
		REFERENCES C1_ADDR ( -- 주소
			ADDRNO -- 주소번호
		);

-- 직원
ALTER TABLE C1_STFF
	ADD CONSTRAINT FK_C1_PROF_TO_C1_STFF -- 개인정보 -> 직원
		FOREIGN KEY (
			PROFNO -- 개인정보번호
		)
		REFERENCES C1_PROF ( -- 개인정보
			PROFNO -- 개인정보번호
		);

-- 직원
ALTER TABLE C1_STFF
	ADD CONSTRAINT FK_C1_BANK_TO_C1_STFF -- 계좌정보 -> 직원
		FOREIGN KEY (
			BANKNO -- 계좌정보번호
		)
		REFERENCES C1_BANK ( -- 계좌정보
			BANKNO -- 계좌정보번호
		);

-- 공급처
ALTER TABLE C1_SUPP
	ADD CONSTRAINT FK_C1_BRCH_TO_C1_SUPP -- 지점 -> 공급처
		FOREIGN KEY (
			BRCHNO -- 지점번호
		)
		REFERENCES C1_BRCH ( -- 지점
			BRCHNO -- 지점번호
		);

-- 공급처
ALTER TABLE C1_SUPP
	ADD CONSTRAINT FK_C1_TERM_TO_C1_SUPP -- 계약기간 -> 공급처
		FOREIGN KEY (
			TRNO -- 계약기간번호
		)
		REFERENCES C1_TERM ( -- 계약기간
			TRNO -- 계약기간번호
		);

-- 음료
ALTER TABLE C1_BVRG
	ADD CONSTRAINT FK_C1_GDS_TO_C1_BVRG -- 상품정보 -> 음료
		FOREIGN KEY (
			GDSNO -- 상품정보번호
		)
		REFERENCES C1_GDS ( -- 상품정보
			GDSNO -- 상품정보번호
		);

-- 지점
ALTER TABLE C1_BRCH
	ADD CONSTRAINT FK_C1_MNG_TO_C1_BRCH -- 지점장 -> 지점
		FOREIGN KEY (
			MNGNO -- 지점장번호
		)
		REFERENCES C1_MNG ( -- 지점장
			MNGNO -- 지점장번호
		);

-- 지점
ALTER TABLE C1_BRCH
	ADD CONSTRAINT FK_C1_ORD_TO_C1_BRCH -- 주문 -> 지점
		FOREIGN KEY (
			ORDNO -- 주문번호
		)
		REFERENCES C1_ORD ( -- 주문
			ORDNO -- 주문번호
		);

-- 지점
ALTER TABLE C1_BRCH
	ADD CONSTRAINT FK_C1_ADDR_TO_C1_BRCH -- 주소 -> 지점
		FOREIGN KEY (
			ADDRNO -- 주소번호
		)
		REFERENCES C1_ADDR ( -- 주소
			ADDRNO -- 주소번호
		);

-- 주문
ALTER TABLE C1_ORD
	ADD CONSTRAINT FK_C1_MD_TO_C1_ORD -- MD 제품 -> 주문
		FOREIGN KEY (
			MDNO -- MD제품번호
		)
		REFERENCES C1_MD ( -- MD 제품
			MDNO -- MD제품번호
		);

-- 주문
ALTER TABLE C1_ORD
	ADD CONSTRAINT FK_C1_FOOD_TO_C1_ORD -- 푸드 -> 주문
		FOREIGN KEY (
			FOODNO -- 푸드번호
		)
		REFERENCES C1_FOOD ( -- 푸드
			FOODNO -- 푸드번호
		);

-- 주문
ALTER TABLE C1_ORD
	ADD CONSTRAINT FK_C1_GIFT_TO_C1_ORD -- 사은품 -> 주문
		FOREIGN KEY (
			GIFTNO -- 사은품번호
		)
		REFERENCES C1_GIFT ( -- 사은품
			GIFTNO -- 사은품번호
		);

-- 주문
ALTER TABLE C1_ORD
	ADD CONSTRAINT FK_C1_BVRG_TO_C1_ORD -- 음료 -> 주문
		FOREIGN KEY (
			BVRGNO -- 음료번호
		)
		REFERENCES C1_BVRG ( -- 음료
			BVRGNO -- 음료번호
		);

-- 배달
ALTER TABLE C1_DEL
	ADD CONSTRAINT FK_C1_ORD_TO_C1_DEL -- 주문 -> 배달
		FOREIGN KEY (
			ORDNO -- 주문번호
		)
		REFERENCES C1_ORD ( -- 주문
			ORDNO -- 주문번호
		);

-- 배달
ALTER TABLE C1_DEL
	ADD CONSTRAINT FK_C1_ADDR_TO_C1_DEL -- 주소 -> 배달
		FOREIGN KEY (
			ADDRNO -- 주소번호
		)
		REFERENCES C1_ADDR ( -- 주소
			ADDRNO -- 주소번호
		);

-- 지점장
ALTER TABLE C1_MNG
	ADD CONSTRAINT FK_C1_ADDR_TO_C1_MNG -- 주소 -> 지점장
		FOREIGN KEY (
			ADDRNO -- 주소번호
		)
		REFERENCES C1_ADDR ( -- 주소
			ADDRNO -- 주소번호
		);

-- 지점장
ALTER TABLE C1_MNG
	ADD CONSTRAINT FK_C1_PROF_TO_C1_MNG -- 개인정보 -> 지점장
		FOREIGN KEY (
			PROFNO -- 개인정보번호
		)
		REFERENCES C1_PROF ( -- 개인정보
			PROFNO -- 개인정보번호
		);

-- 지점장
ALTER TABLE C1_MNG
	ADD CONSTRAINT FK_C1_BANK_TO_C1_MNG -- 계좌정보 -> 지점장
		FOREIGN KEY (
			BANKNO -- 계좌정보번호
		)
		REFERENCES C1_BANK ( -- 계좌정보
			BANKNO -- 계좌정보번호
		);

-- MD 제품
ALTER TABLE C1_MD
	ADD CONSTRAINT FK_C1_GDS_TO_C1_MD -- 상품정보 -> MD 제품
		FOREIGN KEY (
			GDSNO -- 상품정보번호
		)
		REFERENCES C1_GDS ( -- 상품정보
			GDSNO -- 상품정보번호
		);

-- MD 제품
ALTER TABLE C1_MD
	ADD CONSTRAINT FK_C1_TERM_TO_C1_MD -- 계약기간 -> MD 제품
		FOREIGN KEY (
			TRNO -- 계약기간번호
		)
		REFERENCES C1_TERM ( -- 계약기간
			TRNO -- 계약기간번호
		);

-- 푸드
ALTER TABLE C1_FOOD
	ADD CONSTRAINT FK_C1_GDS_TO_C1_FOOD -- 상품정보 -> 푸드
		FOREIGN KEY (
			GDSNO -- 상품정보번호
		)
		REFERENCES C1_GDS ( -- 상품정보
			GDSNO -- 상품정보번호
		);

-- 재고관리
ALTER TABLE C1_STCK
	ADD CONSTRAINT FK_C1_BRCH_TO_C1_STCK -- 지점 -> 재고관리
		FOREIGN KEY (
			BRCHNO -- 지점번호
		)
		REFERENCES C1_BRCH ( -- 지점
			BRCHNO -- 지점번호
		);

-- 멤버십
ALTER TABLE C1_CST_MEMB
	ADD CONSTRAINT FK_C1_CST_TO_C1_CST_MEMB -- 고객 -> 멤버십
		FOREIGN KEY (
			CUNO -- 고객번호
		)
		REFERENCES C1_CST ( -- 고객
			CSTNO -- 고객번호
		);

-- 멤버십
ALTER TABLE C1_CST_MEMB
	ADD CONSTRAINT FK_C1_TERM_TO_C1_CST_MEMB -- 계약기간 -> 멤버십
		FOREIGN KEY (
			TRNO -- 계약기간번호
		)
		REFERENCES C1_TERM ( -- 계약기간
			TRNO -- 계약기간번호
		);

-- 직원관리
ALTER TABLE C1_STFF_MNG
	ADD CONSTRAINT FK_C1_STFF_TO_C1_STFF_MNG -- 직원 -> 직원관리
		FOREIGN KEY (
			STFFNO -- 직원번호
		)
		REFERENCES C1_STFF ( -- 직원
			STFFNO -- 직원번호
		);

-- 사은품
ALTER TABLE C1_GIFT
	ADD CONSTRAINT FK_C1_TERM_TO_C1_GIFT -- 계약기간 -> 사은품
		FOREIGN KEY (
			TRNO -- 계약기간번호
		)
		REFERENCES C1_TERM ( -- 계약기간
			TRNO -- 계약기간번호
		);

-- 고객설문조사
ALTER TABLE C1_CST_SBY
	ADD CONSTRAINT FK_C1_CST_TO_C1_CST_SBY -- 고객 -> 고객설문조사
		FOREIGN KEY (
			CSTNO -- 고객번호
		)
		REFERENCES C1_CST ( -- 고객
			CSTNO -- 고객번호
		);

-- 고객설문조사
ALTER TABLE C1_CST_SBY
	ADD CONSTRAINT FK_C1_STFF_TO_C1_CST_SBY -- 직원 -> 고객설문조사
		FOREIGN KEY (
			STFFNO -- 직원번호
		)
		REFERENCES C1_STFF ( -- 직원
			STFFNO -- 직원번호
		);

-- 결제정보
ALTER TABLE C1_PAY
	ADD CONSTRAINT FK_C1_ORD_TO_C1_PAY -- 주문 -> 결제정보
		FOREIGN KEY (
			ORDNO -- 주문번호
		)
		REFERENCES C1_ORD ( -- 주문
			ORDNO -- 주문번호
		);