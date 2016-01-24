/**
 * Created by donghoon on 2016. 1. 23..
 */
$(document).ready(function () {
    $('.toggle').on('click', function () {
        $('.container').stop().addClass('active');
    });

    $('.close').on('click', function () {
        $('.container').stop().removeClass('active');
    });

    $('#kakao-login-btn').on('click', function () {
        //로그인 버튼 클릭시 마다 인증을 하기 위해 로그아웃을 먼 실행.
        Kakao.Auth.logout(function () {
            Kakao.Auth.login({
                success: function () {
                    memberProcessByKakao();
                },
                fail: function (err) {
                    alert(JSON.stringify(err))
                }
            });
        });
    });

    function memberProcessByKakao() {
        //카카오로 부터 유저 정보 획득하기.
        Kakao.API.request({
            url: '/v1/user/me',
            success: function (response) {
                var id = response.id;
                var nickName = response.properties.nickname;
                var profileImg = response.properties.profile_image;
                var thumbnailImg = response.properties.thumbnail_image;

                //가입된 회원인지 DB 체크.(param: kakaoId)
                $.ajax({
                    url: "isMember",
                    type: "post",
                    data: {
                        userAccountId: id, //controller의 param 이름과 key를 맞춰야함.
                    },
                    success: function (response) {
                        //이미 가입한 회원이면 페이지 이동.
                        if (response === "EXISTUSER") {
                            alert("이미 가입한 회원 입니다. 로그인 하시겠습니까?");
                            //페이지 이동 로직 추가하기.
                            //가입되어 있지 않은 회원의 회원가입 로직.
                        } else if (response === "NOTEXISTUSER") {
                            var signIn = confirm("아직 회원이 아닙니다. kakao로 회원가입 하시겠습니까?");
                            if (signIn === true) {
                                $.ajax({
                                    url: "createMember",
                                    type: "post",
                                    data: {
                                        userAccountId: id,
                                        type: "kakao",
                                        nickName: nickName,
                                        profileImg: profileImg,
                                        thumbnailImg: thumbnailImg
                                    },
                                    success: function (response) {
                                        alert(response + "님의 회원가입이 완료 되었습니다.");
                                        //page 이동 로직 추가하기.
                                    },
                                    fail: function () {
                                        alert("회원가입에 문제가 발생 하였습니다...");
                                    }
                                });
                            } else {
                                alert("가입후에 이용해주세요...");
                            }
                        }
                    },
                    error: function (error) {
                        alert("Server Error!" + JSON.stringify(error));
                    }
                });
            },
            fail: function (error) {
                alert("kakao getUserInfo error: " + JSON.stringify(error));
            }
        });
    }
});
