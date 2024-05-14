# ec2-user

# 현재 경로 출력
pwd

# 현재 위치의 파일 및 폴러 리스트
ls
# -a 옵셩은 모든것을 상세하게 보여달라
ls -a

#현재 시간 확인
data

#현재 타임존이 어디인지
timedatectl 

#타임존 리스트 보기
timedatectl list-timezones

# | 파이프 라인
# grep : 꽉 잡고있다
timedatectl list-timezones | grep Asia/Seoul
Asia/seoul

#타입존 변경(서버가 재시작 후에도 타임존을 확인 할 것)
timedatectl set-timezone Asia/Seoul

# yum <- 설치 툴(centos) 리눅스 최신버전 업데이트
sudo yum update -y