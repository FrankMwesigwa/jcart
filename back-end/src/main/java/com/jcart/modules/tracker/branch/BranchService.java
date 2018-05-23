package com.jcart.modules.tracker.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public Branch findById(Long id) {
        return branchRepository.getOne(id);
    }

    public Branch findByName(String name) {
        return branchRepository.findBybranchName(name);
    }

    public void saveBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void updateBranch(Branch branch){
        saveBranch(branch);
    }

    public void deleteBranchById(Long id){
        branchRepository.deleteById(id);
    }

    public void deleteAllBranch(){
        branchRepository.deleteAll();
    }

    public List<Branch> findAllBranches(){
        return branchRepository.findAll();
    }

    public boolean isBranchExist(Branch branch) {
        return findByName(branch.getBranchName()) != null;
    }
}
