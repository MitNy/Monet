namespace cpp kuber

service DEManagement {
        i32 add_dmEngine(1:string name,2:string fileName,3:i32 port),
        i32 remove_dmEngine(1:string name),
        i32 describe_dmEngine(1:string name),
}