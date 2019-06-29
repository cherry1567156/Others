/**
 * 加载主页
 */
let promise = getJson("/project");
promise.then((jsonData) => {
    let p = document.body;
    let obj = {
        treeJson: jsonData,
        pDom: p,
    };
    var tree = new Tree(obj);
    //p.appendChild(tree.pDom);
});
