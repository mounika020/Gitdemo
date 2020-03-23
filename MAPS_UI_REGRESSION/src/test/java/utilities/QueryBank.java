package utilities;

public class QueryBank {
	public static String INDIVIDUAL_Rx_QUERY = "select Concat(year(g.effectivedate), ' - ',c.ContractNumber, ' - ',p.PBPNumber) as [Year/Contract/PBP],m.MasterGroupNumber as [Master Group],g.GroupNumber as [Group Number], Concat(CONVERT(VARCHAR(10),g.EffectiveDate,101),' - ',CONVERT(VARCHAR(10),g.TerminationDate,101)) as [Group Effective Date/Group Termination Date],ig.SupplementTypeCode as [Supplement Type Code],ig.DURKey as [DUR Key],ig.InternalBIN as [Internal Rx Bin],ig.InternalPCN as [Internal Rx PCN], ig.InternalGroup as [Internal Rx Group] from [Group] g inner join mastergroup m on g.mastergroupid = m.mastergroupid inner join IndividualGroupPlan ig on ig.groupid = g.groupid inner join IndividualPlanDemographic ip on ip.planid = ig.planid inner join [Plan] p on ip.planid = p.planid inner join Contract c on c.contractid = p.contractid where year(g.EffectiveDate) in (2017)and GroupNumber='parameter1'";
}