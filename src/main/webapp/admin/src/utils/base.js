const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm7u2ji/",
            name: "ssm7u2ji",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm7u2ji/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "电影网站"
        } 
    }
}
export default base
