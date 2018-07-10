namespace java monet

service qdmsRPC01 {


	// IF-01-01
	void StartQdmsService (),
	// IF-01-02
	void StopQdmsService (),
	// IF-01-03
	void ReportQdmsService (),
	// IF-01-04
	string AddDmEngine (
		1:string type
		2:string aliasEngine
	) throws (),

	// IF-01-05
	string RemoveDmEngine (
		1:string type
		2:string aliasEngine
	) throws (),

	// IF-01-06
	string StartDmEngine (
		1:string type
		2:i32 dmindex
	) throws (),

	// IF-01-07
	string StopDmEngine (
		1:string type
		2:i32 dmindex
	) throws (),

	// IF-01-08
	string QueryDmEngineSts (
		1:string type
		2:i32 dmindex
	) throws (),
}
