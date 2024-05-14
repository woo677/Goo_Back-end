# 모든 사용자에게 개방하는 방식
# chmod [변경할 권한] [대상 폴더 및 파일]
cd /var/lib 
# 모두가 읽기,쓰기,실행 이 가능 하도록
# (r: 읽기, w:쓰기, x:실행)
chmod rwxrwxrwx docker
# 위 방법은 가독성이 좋지 않아 다른 방법을 사용 한다
# r=> 4 w=> 2 x=>1
# rwx = 4+2+1=> 7 rwx = 4+2+1=> 7 rwx = 4+2+1=> 7
chmod 777 docker
# rwxr_x__x => 751
# rwxr_xr_x => 755 (보통 이렇게 많이 쓴다)
# -R : 하위 폴더까지 모두
chmod -R 755 docker

drwxr-xr-x. 12 root   root     171 May 14 09:25 docker

cd /var/run
sudo chmod 777 docker.sock
sudo chmod 777 docker.pid

-rw-r--r--.  1 root   root              5 May 14 09:25 docker.pid
srw-rw----.  1 root   docker            0 May 14 09:25 docker.sock
docker images # 정상적이면 아무것도 없는 리스트가 나타날 것이다

# 소유자를 변경 하는 방식
# chown [소유주]:[구룹] [대상 파일 및 폴더]
cd /var/lib 
chown ec2-user:ec2-user docker

# chown 이 보안상으로는 더 안전하다
# 하지만 여러 아이디가 사용되는 경우가 더 많기 때문에 chmod 를 사용한다



