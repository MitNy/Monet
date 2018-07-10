namespace java monet

service qdmsRPC03 {
	/* IF-03 */
        // IF-03-01
        string RegisterFile (
                1:string type
                2:string provisionGroupId
                3:string updateGroupId
                4:string fileName
                5:string version
                6:string fileCrc
        ) throws(),

        // IF-03-02
        string UnregisterFile (
                1:string fileId
        ) throws(),

        // IF-03-03
        void QuerySts()
}
